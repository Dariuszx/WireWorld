/*
 * Created by JFormDesigner on Tue Jun 03 21:58:58 CEST 2014
 */

package GUI.editMesh;

import java.awt.event.*;
import Data.Mesh;
import Data.Parameters;
import GUI.errorHandling.ErrorHandlingDialog;
import GUI.visualisation.MeshDrawing;
import Modules.ErrorHandling;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class EditMesh extends JDialog {

    private Parameters parameters;
    private MeshDrawing drawing;
    private JButton buttonPressed;
    private MouseListener mouseListener;
    private Mesh meshTmp;

    public EditMesh( Frame owner, Parameters parameters ) {

        super(owner);
        initComponents();

        this.parameters = parameters;
        this.drawing = new MeshDrawing();
        this.meshTmp = new Mesh();

        try
        {
            if( !parameters.getIsMeshLoaded() ) /* Jeżeli nie wczytano żadnej siatki, to rysuję domyślną */
            {
                parameters.getMesh().makeMesh( 40, 40 );
                parameters.getMesh().copyMesh( parameters.getGeneratedMesh() );
            }

            parameters.getGeneratedMesh().copyMesh( meshTmp );
        }
        catch ( ErrorHandling e )
        {
            new ErrorHandlingDialog( this, e.toString() ).setVisible( true );
        }


        this.mouseListener = new MouseListener( meshTmp, drawing );

        setButtonPressed(buttonPusta);
        mouseListener.setButtonPressed( buttonPressed );

        drawing.addMouseListener( mouseListener ); /* Nasłuchuję na panelu Canvas */

        draw( meshTmp );
    }

    public EditMesh( Dialog owner ) {

        super(owner);
        initComponents();
    }

    private void draw( Mesh mesh ) {

        drawing.setMesh(mesh);

        panelCanvas.add(drawing);

        drawing.setBounds(0, 0, 800, 800);
    }


    private void setButtonPressed( JButton button ) {

        if( buttonPressed != null ) buttonPressed.setEnabled( true );
        buttonPressed = button;
        buttonPressed.setEnabled( false );

        mouseListener.setButtonPressed( buttonPressed );
    }

    private void buttonGlowaActionPerformed( ActionEvent e ) { setButtonPressed( buttonGlowa ); }

    private void buttonPrzewodnikActionPerformed( ActionEvent e ) { setButtonPressed( buttonPrzewodnik ); }

    private void buttonOgonActionPerformed( ActionEvent e ) { setButtonPressed(buttonOgon); }

    private void buttonPustaActionPerformed( ActionEvent e ) { setButtonPressed(buttonPusta); }

    private void buttonDiodeActionPerformed( ActionEvent e ) { setButtonPressed( buttonDiode ); }

    private void buttonXorActionPerformed(ActionEvent e) { setButtonPressed( buttonXor ); }

    private void buttonWyczyscActionPerformed(ActionEvent e) {

        try {

            meshTmp.setZero();
            drawing.repaint();

        } catch ( ErrorHandling error ) {
            new ErrorHandlingDialog( this, e.toString() ).setVisible( true );
        }
    }

    private void buttonResetujActionPerformed(ActionEvent e) {

        try {

            parameters.getGeneratedMesh().copyMesh(meshTmp);
            drawing.repaint();

        } catch ( ErrorHandling error ) {

            new ErrorHandlingDialog(this, e.toString()).setVisible(true);
        }
    }

    private void buttonZapiszActionPerformed(ActionEvent e) {

        try {

            meshTmp.copyMesh( parameters.getGeneratedMesh() );
            this.setVisible( false );
            this.dispose();

        } catch ( ErrorHandling error ) {

            new ErrorHandlingDialog(this, e.toString()).setVisible(true);
        }

    }

    private void buttonWyjdzActionPerformed(ActionEvent e) {

        this.setVisible( false );
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        panelPrzybornik = new JPanel();
        buttonDiode = new JButton();
        buttonGlowa = new JButton();
        buttonOgon = new JButton();
        buttonPrzewodnik = new JButton();
        buttonPusta = new JButton();
        buttonXor = new JButton();
        panelSiatka = new JPanel();
        panelCanvas = new JPanel();
        panelNarzedzia = new JPanel();
        buttonWyczysc = new JButton();
        buttonResetuj = new JButton();
        buttonZapisz = new JButton();
        buttonWyjdz = new JButton();

        //======== this ========
        setTitle("Edytuj siatk\u0119");
        setModal(true);
        Container contentPane = getContentPane();

        //======== panelPrzybornik ========
        {
            panelPrzybornik.setBorder(new TitledBorder("Przybornik"));

            // JFormDesigner evaluation mark
            panelPrzybornik.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelPrzybornik.getBorder())); panelPrzybornik.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- buttonDiode ----
            buttonDiode.setText("Diode");
            buttonDiode.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonDiodeActionPerformed(e);
                }
            });

            //---- buttonGlowa ----
            buttonGlowa.setText("G\u0142owa");
            buttonGlowa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonGlowaActionPerformed(e);
                }
            });

            //---- buttonOgon ----
            buttonOgon.setText("Ogon");
            buttonOgon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonOgonActionPerformed(e);
                }
            });

            //---- buttonPrzewodnik ----
            buttonPrzewodnik.setText("Przewodnik");
            buttonPrzewodnik.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPrzewodnikActionPerformed(e);
                }
            });

            //---- buttonPusta ----
            buttonPusta.setText("Pusta");
            buttonPusta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPustaActionPerformed(e);
                }
            });

            //---- buttonXor ----
            buttonXor.setText("XOR");
            buttonXor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonXorActionPerformed(e);
                }
            });

            GroupLayout panelPrzybornikLayout = new GroupLayout(panelPrzybornik);
            panelPrzybornik.setLayout(panelPrzybornikLayout);
            panelPrzybornikLayout.setHorizontalGroup(
                panelPrzybornikLayout.createParallelGroup()
                    .addGroup(panelPrzybornikLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrzybornikLayout.createParallelGroup()
                            .addComponent(buttonGlowa, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(buttonPrzewodnik, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(buttonOgon, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(buttonPusta, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(buttonDiode, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(buttonXor, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panelPrzybornikLayout.setVerticalGroup(
                panelPrzybornikLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelPrzybornikLayout.createSequentialGroup()
                        .addComponent(buttonGlowa)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPrzewodnik)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOgon)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPusta)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDiode)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonXor)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panelSiatka ========
        {
            panelSiatka.setBorder(new TitledBorder("Siatka"));

            //======== panelCanvas ========
            {

                GroupLayout panelCanvasLayout = new GroupLayout(panelCanvas);
                panelCanvas.setLayout(panelCanvasLayout);
                panelCanvasLayout.setHorizontalGroup(
                    panelCanvasLayout.createParallelGroup()
                        .addGap(0, 500, Short.MAX_VALUE)
                );
                panelCanvasLayout.setVerticalGroup(
                    panelCanvasLayout.createParallelGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                );
            }

            GroupLayout panelSiatkaLayout = new GroupLayout(panelSiatka);
            panelSiatka.setLayout(panelSiatkaLayout);
            panelSiatkaLayout.setHorizontalGroup(
                panelSiatkaLayout.createParallelGroup()
                    .addGroup(panelSiatkaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panelSiatkaLayout.setVerticalGroup(
                panelSiatkaLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panelSiatkaLayout.createSequentialGroup()
                        .addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        //======== panelNarzedzia ========
        {
            panelNarzedzia.setBorder(new TitledBorder("Narz\u0119dzia"));

            //---- buttonWyczysc ----
            buttonWyczysc.setText("Wyczy\u015b\u0107");
            buttonWyczysc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonWyczyscActionPerformed(e);
                }
            });

            //---- buttonResetuj ----
            buttonResetuj.setText("Resetuj");
            buttonResetuj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonResetujActionPerformed(e);
                }
            });

            //---- buttonZapisz ----
            buttonZapisz.setText("Zapisz");
            buttonZapisz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonZapiszActionPerformed(e);
                }
            });

            //---- buttonWyjdz ----
            buttonWyjdz.setText("Wyjd\u017a");
            buttonWyjdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonWyjdzActionPerformed(e);
                }
            });

            GroupLayout panelNarzedziaLayout = new GroupLayout(panelNarzedzia);
            panelNarzedzia.setLayout(panelNarzedziaLayout);
            panelNarzedziaLayout.setHorizontalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(panelNarzedziaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelNarzedziaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonZapisz, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonWyjdz, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelNarzedziaLayout.createParallelGroup()
                                .addComponent(buttonWyczysc, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonResetuj, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panelNarzedziaLayout.setVerticalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(panelNarzedziaLayout.createSequentialGroup()
                        .addComponent(buttonWyczysc)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonResetuj)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(buttonZapisz)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyjdz)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelPrzybornik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelNarzedzia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panelPrzybornik, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelNarzedzia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JPanel panelPrzybornik;
    private JButton buttonDiode;
    private JButton buttonGlowa;
    private JButton buttonOgon;
    private JButton buttonPrzewodnik;
    private JButton buttonPusta;
    private JButton buttonXor;
    private JPanel panelSiatka;
    private JPanel panelCanvas;
    private JPanel panelNarzedzia;
    private JButton buttonWyczysc;
    private JButton buttonResetuj;
    private JButton buttonZapisz;
    private JButton buttonWyjdz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
