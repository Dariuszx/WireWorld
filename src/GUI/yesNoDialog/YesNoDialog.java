/*
 * Created by JFormDesigner on Thu May 22 22:11:52 CEST 2014
 */

package GUI.yesNoDialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class YesNoDialog extends JDialog {

    private boolean optionSelected = false;

    public YesNoDialog( Frame owner ) {

        super(owner);
        initComponents();
    }

    private void buttonTakActionPerformed(ActionEvent e) {

        optionSelected = true;
        this.dispatchEvent( new WindowEvent( this,  WindowEvent.WINDOW_CLOSING ) );
    }

    private void buttonNieActionPerformed(ActionEvent e) {

        optionSelected = false;
        this.dispatchEvent( new WindowEvent( this,  WindowEvent.WINDOW_CLOSING ) );
    }

    public boolean getOptionSelected() {
        return optionSelected;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        buttonNie = new JButton();
        buttonTak = new JButton();
        labelTytul = new JLabel();

        //======== this ========
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setModal(true);
        Container contentPane = getContentPane();

        //---- buttonNie ----
        buttonNie.setText("Nie");
        buttonNie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNieActionPerformed(e);
            }
        });

        //---- buttonTak ----
        buttonTak.setText("Tak");
        buttonTak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonTakActionPerformed(e);
            }
        });

        //---- labelTytul ----
        labelTytul.setText("Czy na pewno?");
        labelTytul.setFont(labelTytul.getFont().deriveFont(labelTytul.getFont().getSize() + 1f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(buttonNie)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonTak))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(labelTytul)))
                    .addContainerGap(88, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(labelTytul)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonNie)
                        .addComponent(buttonTak))
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        setSize(290, 105);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JButton buttonNie;
    private JButton buttonTak;
    private JLabel labelTytul;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
