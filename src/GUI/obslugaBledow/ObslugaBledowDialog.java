/*
 * Created by JFormDesigner on Sat May 24 20:48:38 CEST 2014
 */

package GUI.obslugaBledow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

public class ObslugaBledowDialog extends JDialog {

    public ObslugaBledowDialog( Frame owner, String title ) {
        super(owner);
        initComponents();

        labelMessage.setText( title );
    }

    public ObslugaBledowDialog( Dialog owner, String title ) {

        super(owner);
        initComponents();

        labelMessage.setText( title );
    }

    private void buttonOkActionPerformed(ActionEvent e) {

        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        labelMessage = new JLabel();
        labelTitle = new JLabel();
        buttonOk = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- labelMessage ----
        labelMessage.setText("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        labelMessage.setHorizontalAlignment(SwingConstants.CENTER);

        //---- labelTitle ----
        labelTitle.setText("UWAGA!");
        labelTitle.setFont(labelTitle.getFont().deriveFont(labelTitle.getFont().getSize() + 10f));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonOk ----
        buttonOk.setText("Ok");
        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(labelTitle, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addComponent(labelMessage, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(buttonOk)
                    .addContainerGap(254, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(labelTitle)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelMessage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonOk)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JLabel labelMessage;
    private JLabel labelTitle;
    private JButton buttonOk;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
