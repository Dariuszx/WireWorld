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
        menuItemOtworzPlik = new JMenuItem();
        menuItemZapiszDoPliku = new JMenuItem();
        menuItemExit = new JMenuItem();
        menuOpcje = new JMenu();
        menuItemParametryGeneracji = new JMenuItem();
        menuItemOkreslZasady = new JMenuItem();
        menuPomoc = new JMenu();
        menuItemOProgramie = new JMenuItem();
        buttonStart = new JButton();
        buttonPauza = new JButton();
        buttonStop = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("WireWorld");
        setLocationByPlatform(true);
        setResizable(false);
        setBackground(new Color(60, 63, 65));
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
                menuFile.setText("Plik");

                //---- menuItemOtworzPlik ----
                menuItemOtworzPlik.setText("Otw\u00f3rz plik...");
                menuFile.add(menuItemOtworzPlik);

                //---- menuItemZapiszDoPliku ----
                menuItemZapiszDoPliku.setText("Zapisz do pliku...");
                menuFile.add(menuItemZapiszDoPliku);

                //---- menuItemExit ----
                menuItemExit.setText("Wyj\u015bcie");
                menuItemExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemExitActionPerformed(e);
                    }
                });
                menuFile.add(menuItemExit);
            }
            mainMenuBar.add(menuFile);

            //======== menuOpcje ========
            {
                menuOpcje.setText("Opcje");

                //---- menuItemParametryGeneracji ----
                menuItemParametryGeneracji.setText("Parametry generacji");
                menuOpcje.add(menuItemParametryGeneracji);

                //---- menuItemOkreslZasady ----
                menuItemOkreslZasady.setText("Okre\u015bl zasady");
                menuOpcje.add(menuItemOkreslZasady);
            }
            mainMenuBar.add(menuOpcje);

            //======== menuPomoc ========
            {
                menuPomoc.setText("Pomoc");

                //---- menuItemOProgramie ----
                menuItemOProgramie.setText("O programie");
                menuPomoc.add(menuItemOProgramie);
            }
            mainMenuBar.add(menuPomoc);
        }
        setJMenuBar(mainMenuBar);

        //---- buttonStart ----
        buttonStart.setText("Start");

        //---- buttonPauza ----
        buttonPauza.setText("Pauza");

        //---- buttonStop ----
        buttonStop.setText("Stop");

        //---- label1 ----
        label1.setText("Generacja:");

        //---- label2 ----
        label2.setText("10");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonPauza)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(buttonStop, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonStart)
                        .addComponent(buttonPauza)
                        .addComponent(buttonStop)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addContainerGap(317, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Dariusz Dybka
    private JMenuBar mainMenuBar;
    private JMenu menuFile;
    private JMenuItem menuItemOtworzPlik;
    private JMenuItem menuItemZapiszDoPliku;
    private JMenuItem menuItemExit;
    private JMenu menuOpcje;
    private JMenuItem menuItemParametryGeneracji;
    private JMenuItem menuItemOkreslZasady;
    private JMenu menuPomoc;
    private JMenuItem menuItemOProgramie;
    private JButton buttonStart;
    private JButton buttonPauza;
    private JButton buttonStop;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
