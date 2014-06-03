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

    public EditMesh( Frame owner, Parameters parameters ) {

        super(owner);
        initComponents();

        this.buttonPressed = buttonPusta;
        this.parameters = parameters;

        drawing = new MeshDrawing();

        drawing.addMouseListener( new MouseListener() {
            @Override
            public void mouseClicked( MouseEvent mouseEvent ) {
                System.out.println( mouseEvent.getX() + " " + mouseEvent.getY() );
            }

            @Override
            public void mousePressed( MouseEvent mouseEvent ) {

            }

            @Override
            public void mouseReleased( MouseEvent mouseEvent ) {

            }

            @Override
            public void mouseEntered( MouseEvent mouseEvent ) {

            }

            @Override
            public void mouseExited( MouseEvent mouseEvent ) {

            }
        });

        if( !parameters.getIsMeshLoaded() ) { /* Jeżeli nie wczytano żadnej siatki, to rysuję domyślną */

            try
            {
                Mesh tmp = new Mesh();
                tmp.makeMesh( 40, 40 );
                parameters.setMesh( tmp );
            }
            catch( ErrorHandling e )
            {
                new ErrorHandlingDialog( this, e.toString() ).setVisible( true );
            }
        }

        draw( parameters.getGeneratedMesh());
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

    private void panelCanvasMouseClicked( MouseEvent e ) {

        System.out.println(e.getX() + " " + e.getY());
    }

    private void panelCanvasMousePressed(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }

    private void panelSiatkaMouseClicked(MouseEvent e) {
        System.out.println( e.getX() + " " + e.getY() );
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

            //---- buttonGlowa ----
            buttonGlowa.setText("G\u0142owa");

            //---- buttonOgon ----
            buttonOgon.setText("Ogon");

            //---- buttonPrzewodnik ----
            buttonPrzewodnik.setText("Przewodnik");

            //---- buttonPusta ----
            buttonPusta.setText("Pusta");

            GroupLayout panelPrzybornikLayout = new GroupLayout(panelPrzybornik);
            panelPrzybornik.setLayout(panelPrzybornikLayout);
            panelPrzybornikLayout.setHorizontalGroup(
                panelPrzybornikLayout.createParallelGroup()
                    .addGroup(panelPrzybornikLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrzybornikLayout.createParallelGroup()
                            .addComponent(buttonGlowa, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(buttonPrzewodnik, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(buttonOgon, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(buttonPusta, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(buttonDiode, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDiode)
                        .addContainerGap())
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
                        .addGap(0, 502, Short.MAX_VALUE)
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

            //---- buttonResetuj ----
            buttonResetuj.setText("Resetuj");

            //---- buttonZapisz ----
            buttonZapisz.setText("Zapisz");

            //---- buttonWyjdz ----
            buttonWyjdz.setText("Wyjd\u017a");

            GroupLayout panelNarzedziaLayout = new GroupLayout(panelNarzedzia);
            panelNarzedzia.setLayout(panelNarzedziaLayout);
            panelNarzedziaLayout.setHorizontalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(panelNarzedziaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelNarzedziaLayout.createParallelGroup()
                            .addGroup(panelNarzedziaLayout.createSequentialGroup()
                                .addGroup(panelNarzedziaLayout.createParallelGroup()
                                    .addComponent(buttonWyczysc, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonResetuj, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelNarzedziaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelNarzedziaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonZapisz, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(buttonWyjdz, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
                        .addContainerGap())
            );
            panelNarzedziaLayout.setVerticalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGroup(panelNarzedziaLayout.createSequentialGroup()
                        .addComponent(buttonWyczysc)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonResetuj)
                        .addGap(66, 66, 66)
                        .addComponent(buttonZapisz)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyjdz)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelNarzedzia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(panelPrzybornik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelSiatka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panelPrzybornik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
    private JPanel panelSiatka;
    private JPanel panelCanvas;
    private JPanel panelNarzedzia;
    private JButton buttonWyczysc;
    private JButton buttonResetuj;
    private JButton buttonZapisz;
    private JButton buttonWyjdz;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
