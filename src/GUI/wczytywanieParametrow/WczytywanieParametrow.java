/*
 * Created by JFormDesigner on Sat May 24 14:40:12 CEST 2014
 */

package GUI.wczytywanieParametrow;

import java.awt.event.*;
import Data.Parameters;
import Modules.ErrorHandling;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class WczytywanieParametrow extends JDialog {

    private Parameters parameters;

    public WczytywanieParametrow(Frame owner, Parameters parameters ) {

        super(owner);
        this.parameters = parameters;
        initComponents();

        inputLiczbaGeneracji.setText( Integer.toString( parameters.getNumberOfGenerations() ) );
        inputOdstepCzasu.setText( Integer.toString( parameters.getInterval() ) );
    }

    public WczytywanieParametrow(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void buttonZapiszActionPerformed(ActionEvent e) {

        try {

            parameters.setNumberOfGenerations(Integer.parseInt(inputLiczbaGeneracji.getText()));
            parameters.setInterval(Integer.parseInt(inputOdstepCzasu.getText()));

            this.dispose();

        } catch ( ErrorHandling error ) {

            //TODO wyświetlić komunikat
        } catch ( NumberFormatException error ) {

            //TODO wyświetlić komunikat
        } finally {
            this.dispose();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        labelTitle = new JLabel();
        labelLiczbaGeneracji = new JLabel();
        labelOdstepCzasu = new JLabel();
        inputLiczbaGeneracji = new JTextField();
        inputOdstepCzasu = new JTextField();
        buttonZapisz = new JButton();
        label1 = new JLabel();

        //======== this ========
        setModal(true);
        setResizable(false);
        Container contentPane = getContentPane();

        //---- labelTitle ----
        labelTitle.setText("Ustawienia tworzenia generacji.");
        labelTitle.setFont(labelTitle.getFont().deriveFont(labelTitle.getFont().getSize() + 4f));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //---- labelLiczbaGeneracji ----
        labelLiczbaGeneracji.setText("Liczba generacji:");
        labelLiczbaGeneracji.setToolTipText("Ilo\u015b\u0107 wygenerowanych generacji.");

        //---- labelOdstepCzasu ----
        labelOdstepCzasu.setText("Odst\u0119p czasu:");
        labelOdstepCzasu.setToolTipText("Odst\u0119p czasu pomi\u0119dzy kolejnymi generacjami.");

        //---- buttonZapisz ----
        buttonZapisz.setText("Zapisz");
        buttonZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonZapiszActionPerformed(e);
            }
        });

        //---- label1 ----
        label1.setText("milisekund");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(labelTitle, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonZapisz)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(92, 92, 92)
                                    .addComponent(labelOdstepCzasu))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(labelLiczbaGeneracji)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(inputOdstepCzasu, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputLiczbaGeneracji, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label1)
                    .addContainerGap(47, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(labelTitle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelLiczbaGeneracji)
                        .addComponent(inputLiczbaGeneracji, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelOdstepCzasu)
                        .addComponent(inputOdstepCzasu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonZapisz)
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JLabel labelTitle;
    private JLabel labelLiczbaGeneracji;
    private JLabel labelOdstepCzasu;
    private JTextField inputLiczbaGeneracji;
    private JTextField inputOdstepCzasu;
    private JButton buttonZapisz;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
