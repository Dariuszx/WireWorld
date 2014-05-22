/*
 * Created by JFormDesigner on Thu May 22 20:41:12 CEST 2014
 */

package GUI.mainWindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.plaf.*;

import GUI.yesNoDialog.YesNoDialog;
import org.jdesktop.beansbinding.*;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class MainWindow extends JFrame {

    public MainWindow() {

        initComponents();
    }

    private void thisWindowClosing(WindowEvent e) {

        closingOperation();
    }

    private void closingOperation() {

        YesNoDialog dialog = new YesNoDialog(this);
        dialog.setVisible(true);

        if( dialog.getOptionSelected() ) close();
    }

    private void close() {

        this.setVisible(false);
        this.dispose();
    }

    private void menuItemExitActionPerformed(ActionEvent e) {

        closingOperation();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Dariusz Dybka
        mainMenuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemExit = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("WireWorld");
        setLocationByPlatform(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //======== mainMenuBar ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");

                //---- menuItemExit ----
                menuItemExit.setText("Exit");
                menuItemExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemExitActionPerformed(e);
                    }
                });
                menuFile.add(menuItemExit);
            }
            mainMenuBar.add(menuFile);
        }
        setJMenuBar(mainMenuBar);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 483, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 318, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JMenuBar mainMenuBar;
    private JMenu menuFile;
    private JMenuItem menuItemExit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
