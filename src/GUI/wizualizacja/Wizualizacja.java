/*
 * Created by JFormDesigner on Sun May 25 18:25:23 CEST 2014
 */

package GUI.wizualizacja;

import java.awt.event.*;
import javax.swing.border.*;
import Data.Parametry;
import Data.Siatka;
import Data.Zdarzenia;
import GUI.obslugaBledow.ObslugaBledowDialog;
import Modules.Observable;
import Modules.Observer;
import Modules.ObslugaBledow;
import Modules.WyswietlSiatke;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

public class Wizualizacja extends JDialog implements Observable, Runnable {

    private Parametry parametry;
    private Thread threadRysowanieSiatki;
    private ArrayList<Observer> observerArrayList;
    private RysowanieSiatki rysowanie;


    private volatile boolean stopThread = false;

    public Wizualizacja( Frame owner, Parametry parametry ) {

        super(owner);
        this.parametry = parametry;
        this.observerArrayList = new ArrayList<Observer>();

        initComponents();

        setSize( new Dimension( 640, 500 ) );

        labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );
        labelGeneracjaIlosc.setText( Integer.toString( parametry.getIloscGeneracji() ) );

        rysowanie = new RysowanieSiatki();


        rysowanie.setSiatka( parametry.getWygenerowanaSiatka() );
        panelCanvas.add( rysowanie );
        rysowanie.setBounds( 0, 0, 800, 800 );

        if( parametry.getSiatka() != null ) {
            buttonStart.setEnabled( true );
        }
    }

    public Wizualizacja(Dialog owner) {

        super(owner);
        initComponents();
    }

    @Override
    public void dodajObserwatora( Observer o ) {

        observerArrayList.add(o);
    }

    @Override
    public void usunObserwatora( Observer o ) {

    }

    @Override
    public void powiadomObserwatorow() {

        try {

            for ( Observer o : observerArrayList ) {
                o.update(parametry);
            }

        } catch( ObslugaBledow e ) {

            new ObslugaBledowDialog( this, e.toString() ).setVisible( true );
        }
    }

    @Override
    public void run() {

        int numerGneracji =  parametry.getGeneracjaIndex();

        while( !stopThread && parametry.getGeneracjaIndex() < parametry.getIloscGeneracji() ) { //Tutaj rysuję kolejne generacje siatek
            powiadomObserwatorow();
            labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );

            if( numerGneracji != parametry.getGeneracjaIndex() ) {
                numerGneracji = parametry.getGeneracjaIndex();

                rysowanie.setSiatka( parametry.getWygenerowanaSiatka() );

                panelCanvas.add( rysowanie );

                rysowanie.setBounds( 0, 0, 800, 800 );
            }
        }

        if( parametry.getGeneracjaIndex() >= parametry.getIloscGeneracji() ) {
            buttonStart.setEnabled(false);
            buttonRestart.setEnabled(true);
            buttonStop.setEnabled(false);
            buttonPauza.setEnabled(false);
        }

    }

    private void rozpocznijGenerowanie() {

        while( threadRysowanieSiatki != null && threadRysowanieSiatki.isAlive() ) {
            stopThread = true;
        }

        stopThread = false;

        threadRysowanieSiatki = new Thread( this );
        threadRysowanieSiatki.start();
    }

    private void zatrzymajGenerowanie() {

        stopThread = true;
    }

    private void buttonStartActionPerformed(ActionEvent e) {

        parametry.setGeneracjaStarted(true);
        parametry.setAutomatKomorkowyZdarzenie( Zdarzenia.START );

        buttonStart.setEnabled( false );
        buttonPauza.setEnabled( true );
        buttonRestart.setEnabled( true );
        buttonStop.setEnabled( true );

        powiadomObserwatorow();

        rozpocznijGenerowanie();
    }

    private void buttonStopActionPerformed(ActionEvent e) {

        parametry.setAutomatKomorkowyZdarzenie(Zdarzenia.STOP);

        buttonStop.setEnabled(false);
        buttonRestart.setEnabled( false );
        buttonPauza.setEnabled( false );
        buttonStart.setEnabled( true );

        powiadomObserwatorow();
        zatrzymajGenerowanie();
    }

    private void buttonPauzaActionPerformed(ActionEvent e) {

        parametry.setAutomatKomorkowyZdarzenie( Zdarzenia.PAUZA );

        buttonStart.setEnabled(true);
        buttonPauza.setEnabled(false);
        buttonStop.setEnabled( true );
        buttonRestart.setEnabled( true );

        stopThread = true;
    }

    private void buttonRestartActionPerformed(ActionEvent e) {

        parametry.setAutomatKomorkowyZdarzenie( Zdarzenia.RESTART );

        buttonStart.setEnabled( false );
        buttonPauza.setEnabled( true );
        buttonRestart.setEnabled( true );
        buttonStop.setEnabled( true );

        powiadomObserwatorow();

        rozpocznijGenerowanie();
    }

    private void thisWindowClosing(WindowEvent e) {

        stopThread = true;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        buttonStart = new JButton();
        buttonPauza = new JButton();
        buttonStop = new JButton();
        buttonRestart = new JButton();
        labelGneracja = new JLabel();
        labelGeneracjaIndex = new JLabel();
        labelSlash = new JLabel();
        labelGeneracjaIlosc = new JLabel();
        panelCanvas = new JPanel();
        panel1 = new JPanel();

        //======== this ========
        setModal(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- buttonStart ----
        buttonStart.setText("Start");
        buttonStart.setEnabled(false);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStartActionPerformed(e);
            }
        });

        //---- buttonPauza ----
        buttonPauza.setText("Pauza");
        buttonPauza.setEnabled(false);
        buttonPauza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPauzaActionPerformed(e);
            }
        });

        //---- buttonStop ----
        buttonStop.setText("Stop");
        buttonStop.setEnabled(false);
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStopActionPerformed(e);
            }
        });

        //---- buttonRestart ----
        buttonRestart.setText("Rozpocznij od nowa");
        buttonRestart.setEnabled(false);
        buttonRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonRestartActionPerformed(e);
            }
        });

        //---- labelGneracja ----
        labelGneracja.setText("Generacja nr:");

        //---- labelGeneracjaIndex ----
        labelGeneracjaIndex.setText("5");
        labelGeneracjaIndex.setHorizontalAlignment(SwingConstants.RIGHT);

        //---- labelSlash ----
        labelSlash.setText("/");

        //---- labelGeneracjaIlosc ----
        labelGeneracjaIlosc.setText("10");
        labelGeneracjaIlosc.setHorizontalAlignment(SwingConstants.LEFT);

        //======== panelCanvas ========
        {

            // JFormDesigner evaluation mark
            panelCanvas.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelCanvas.getBorder())); panelCanvas.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panelCanvas.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            panelCanvas.add(panel1);
            panel1.setBounds(500, 0, panel1.getPreferredSize().width, 275);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panelCanvas.getComponentCount(); i++) {
                    Rectangle bounds = panelCanvas.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panelCanvas.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panelCanvas.setMinimumSize(preferredSize);
                panelCanvas.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(buttonStart)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonPauza)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonStop)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonRestart)
                            .addGap(18, 18, 18)
                            .addComponent(labelGneracja)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelGeneracjaIndex, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelSlash)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelGeneracjaIlosc, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 90, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonStart)
                            .addComponent(buttonPauza)
                            .addComponent(buttonStop)
                            .addComponent(buttonRestart)
                            .addComponent(labelSlash)
                            .addComponent(labelGneracja)
                            .addComponent(labelGeneracjaIndex)
                            .addComponent(labelGeneracjaIlosc))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelCanvas, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        setSize(640, 495);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JButton buttonStart;
    private JButton buttonPauza;
    private JButton buttonStop;
    private JButton buttonRestart;
    private JLabel labelGneracja;
    private JLabel labelGeneracjaIndex;
    private JLabel labelSlash;
    private JLabel labelGeneracjaIlosc;
    private JPanel panelCanvas;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
