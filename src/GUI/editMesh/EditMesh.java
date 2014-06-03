/*
 * Created by JFormDesigner on Tue Jun 03 21:58:58 CEST 2014
 */

package GUI.editMesh;

import Data.Parameters;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

public class EditMesh extends JDialog {

    private Parameters parameters;

    public EditMesh( Frame owner, Parameters parameters ) {

        super(owner);
        initComponents();

        this.parameters = parameters;
    }

    public EditMesh(Dialog owner) {

        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        panelPrzybornik = new JPanel();
        panelSiatka = new JPanel();
        panelCanvas = new JPanel();
        panelNarzedzia = new JPanel();

        //======== this ========
        setTitle("Edytuj siatk\u0119");
        setModal(true);
        Container contentPane = getContentPane();

        //======== panelPrzybornik ========
        {
            panelPrzybornik.setBorder(new TitledBorder("Przybornik"));
/*
            // JFormDesigner evaluation mark
            panelPrzybornik.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panelPrzybornik.getBorder())); panelPrzybornik.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
*/

            GroupLayout panelPrzybornikLayout = new GroupLayout(panelPrzybornik);
            panelPrzybornik.setLayout(panelPrzybornikLayout);
            panelPrzybornikLayout.setHorizontalGroup(
                panelPrzybornikLayout.createParallelGroup()
                    .addGap(0, 172, Short.MAX_VALUE)
            );
            panelPrzybornikLayout.setVerticalGroup(
                panelPrzybornikLayout.createParallelGroup()
                    .addGap(0, 182, Short.MAX_VALUE)
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
                        .addGap(0, 476, Short.MAX_VALUE)
                );
                panelCanvasLayout.setVerticalGroup(
                    panelCanvasLayout.createParallelGroup()
                        .addGap(0, 405, Short.MAX_VALUE)
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

            GroupLayout panelNarzedziaLayout = new GroupLayout(panelNarzedzia);
            panelNarzedzia.setLayout(panelNarzedziaLayout);
            panelNarzedziaLayout.setHorizontalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGap(0, 172, Short.MAX_VALUE)
            );
            panelNarzedziaLayout.setVerticalGroup(
                panelNarzedziaLayout.createParallelGroup()
                    .addGap(0, 202, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSiatka, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(panelPrzybornik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JPanel panelSiatka;
    private JPanel panelCanvas;
    private JPanel panelNarzedzia;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
