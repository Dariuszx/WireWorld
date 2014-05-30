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
    private Ustawienia ustawieniaGraficzne;


    private volatile boolean stopThread = false;

    public Wizualizacja( Frame owner, Parametry parametry ) {

        super(owner);
        this.parametry = parametry;
        this.observerArrayList = new ArrayList<Observer>();

        initComponents();

        this.ustawieniaGraficzne = new Ustawienia( parametry.getWygenerowanaSiatka(), new Dimension( 709, 452 ) );

        rysowanie = new RysowanieSiatki( ustawieniaGraficzne );


        rysuj( parametry.getSiatka() );

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
            //labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );

            if( numerGneracji != parametry.getGeneracjaIndex() ) {
                numerGneracji = parametry.getGeneracjaIndex();

                rysuj( parametry.getWygenerowanaSiatka() );

                labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );
            }
        }

        if( parametry.getGeneracjaIndex() >= parametry.getIloscGeneracji() ) {

            buttonStart.setEnabled(true);
            buttonStop.setEnabled(false);
            buttonPauza.setEnabled(false);

            parametry.setWygenerowanaSiatka( parametry.getSiatka() );
            parametry.setGeneracjIndex( 0 );
        }

    }

    private void rysuj( Siatka siatka ) {

        rysowanie.setSiatka( siatka );

        panelCanvas.add( rysowanie );

        rysowanie.setBounds( 0, 0, 800, 800 );
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

        parametry.setWygenerowanaSiatka( parametry.getSiatka() );
    }

    private void buttonStartActionPerformed(ActionEvent e) {

        parametry.setGeneracjaStarted(true);
        parametry.setAutomatKomorkowyZdarzenie( Zdarzenia.START );

        buttonStart.setEnabled( false );
        buttonPauza.setEnabled( true );
        buttonStop.setEnabled( true );

        powiadomObserwatorow();

        rysuj( parametry.getSiatka() );

        rozpocznijGenerowanie();
    }

    private void buttonStopActionPerformed(ActionEvent e) {

        parametry.setAutomatKomorkowyZdarzenie(Zdarzenia.STOP);

        buttonStop.setEnabled(false);
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

        stopThread = true;
    }

    private void thisWindowClosing(WindowEvent e) {

        stopThread = true;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        panelNarzedzia = new JPanel();
        buttonStart = new JButton();
        buttonPauza = new JButton();
        buttonStop = new JButton();
        label1 = new JLabel();
        labelGeneracjaIndex = new JLabel();
        panelSiatka = new JPanel();
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

        //======== panelNarzedzia ========
        {
            panelNarzedzia.setBorder(new TitledBorder("Przybornik"));

            // JFormDesigner evaluation mark
            panelNarzedzia.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelNarzedzia.getBorder())); panelNarzedzia.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


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

            //---- label1 ----
            label1.setText("Licznik generacji:");
            label1.setHorizontalAlignment(SwingConstants.RIGHT);

            //---- labelGeneracjaIndex ----
            labelGeneracjaIndex.setText("0");

            GroupLayout panelNarzedziaLayout = new GroupLayout(panelNarzedzia);
            panelNarzedzia.setLayout(panelNarzedziaLayout);
            panelNarzedziaLayout.setHorizontalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(panelNarzedziaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStop, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPauza, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelGeneracjaIndex, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(277, Short.MAX_VALUE))
            );
            panelNarzedziaLayout.setVerticalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelNarzedziaLayout.createSequentialGroup()
                        .addGroup(panelNarzedziaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonStart)
                            .addComponent(buttonStop)
                            .addComponent(buttonPauza)
                            .addComponent(labelGeneracjaIndex)
                            .addComponent(label1))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panelSiatka ========
        {
            panelSiatka.setBorder(new TitledBorder("Siatka wygenerowana"));

            //======== panelCanvas ========
            {
                panelCanvas.setBorder(null);
                panelCanvas.setPreferredSize(new Dimension(663, 436));
                panelCanvas.setMinimumSize(new Dimension(663, 436));
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

            GroupLayout panelSiatkaLayout = new GroupLayout(panelSiatka);
            panelSiatka.setLayout(panelSiatkaLayout);
            panelSiatkaLayout.setHorizontalGroup(
                panelSiatkaLayout.createParallelGroup()
                    .addGroup(panelSiatkaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panelSiatkaLayout.setVerticalGroup(
                panelSiatkaLayout.createParallelGroup()
                    .addGroup(panelSiatkaLayout.createSequentialGroup()
                        .addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelNarzedzia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelNarzedzia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        setSize(755, 580);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JPanel panelNarzedzia;
    private JButton buttonStart;
    private JButton buttonPauza;
    private JButton buttonStop;
    private JLabel label1;
    private JLabel labelGeneracjaIndex;
    private JPanel panelSiatka;
    private JPanel panelCanvas;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
