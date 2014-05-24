/*
 * Created by JFormDesigner on Sat May 24 14:40:12 CEST 2014
 */

package GUI.wczytywanieParametrow;

import java.awt.event.*;
import Data.Parametry;
import Modules.ObslugaBledow;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class WczytywanieParametrow extends JDialog {

    private Parametry parametry;

    public WczytywanieParametrow(Frame owner, Parametry parametry) {

        super(owner);
        this.parametry = parametry;
        initComponents();

        inputLiczbaGeneracji.setText( Integer.toString( parametry.getIloscGeneracji() ) );
        inputOdstepCzasu.setText( Integer.toString( parametry.getOdstepCzasu() ) );
    }

    public WczytywanieParametrow(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void buttonZapiszActionPerformed(ActionEvent e) {

        try {

            parametry.setIloscGeneracji( Integer.parseInt( inputLiczbaGeneracji.getText() ) );
            parametry.setOdstepCzasu( Integer.parseInt( inputOdstepCzasu.getText() ) );

            this.dispose();

        } catch ( ObslugaBledow error ) {

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
                    .addContainerGap(74, Short.MAX_VALUE))
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
                        .addComponent(inputOdstepCzasu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
