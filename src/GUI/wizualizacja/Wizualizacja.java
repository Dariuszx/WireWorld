/*
 * Created by JFormDesigner on Sun May 25 18:25:23 CEST 2014
 */

package GUI.wizualizacja;

import java.awt.event.*;
import Data.Parametry;
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

    private volatile boolean stopThread = false;

    public Wizualizacja( Frame owner, Parametry parametry ) {

        super(owner);
        this.parametry = parametry;
        this.observerArrayList = new ArrayList<Observer>();

        initComponents();

        labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );
        labelGeneracjaIlosc.setText( Integer.toString( parametry.getIloscGeneracji() ) );

        if( parametry.getSiatka() != null ) buttonStart.setEnabled( true );

        new WyswietlSiatke( parametry.getSiatka() );
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

        while( !stopThread && parametry.getGeneracjaIndex() < parametry.getIloscGeneracji() ) { //Tutaj rysuję kolejne generacje siatek
            powiadomObserwatorow();
            labelGeneracjaIndex.setText( Integer.toString( parametry.getGeneracjaIndex() ) );
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

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
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
                    .addContainerGap())
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
                    .addContainerGap(288, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
