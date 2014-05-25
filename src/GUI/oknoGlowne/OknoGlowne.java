/*
 * Created by JFormDesigner on Thu May 22 20:41:12 CEST 2014
 */

package GUI.oknoGlowne;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import Data.Parametry;
import GUI.openFile.OpenFile;
import GUI.wczytywanieParametrow.WczytywanieParametrow;
import GUI.wizualizacja.Wizualizacja;
import GUI.yesNoDialog.YesNoDialog;
import GUI.zapiszPlik.ZapiszPlik;
import GUI.obslugaBledow.ObslugaBledowDialog;
import Modules.Observable;
import Modules.Observer;
import Modules.ObslugaBledow;


public class OknoGlowne extends JFrame implements Observable {

    private ArrayList<Observer> obserwatorzy;
    private Parametry parametry;

    private Observer automatKomorkowy;

    public OknoGlowne( Parametry parametry ) {

        this.parametry = parametry;
        initComponents();
        obserwatorzy = new ArrayList<Observer>();
    }

    public void dodajObserwatorAutomatKomorkowy( Observer automatKomorkowy ) {

        this.automatKomorkowy = automatKomorkowy;
    }

    @Override
    public void dodajObserwatora( Observer o ) {

        obserwatorzy.add( o );
    }

    @Override
    public void usunObserwatora( Observer o ) {

        int index = obserwatorzy.indexOf(o);
        obserwatorzy.remove(index);
    }

    @Override
    public void powiadomObserwatorow() {

        for( Observer o : obserwatorzy ) {
            try {

                o.update(parametry);
            } catch ( ObslugaBledow e ) {

                new ObslugaBledowDialog( this, e.toString() ).setVisible( true );
            }
        }
    }

    private void menuItemExitActionPerformed(ActionEvent e) {

        closingOperation();
    }

    //Akcja Zapisz Do Pliku
    private void menuItemZapiszDoPlikuActionPerformed(ActionEvent e) {

        ZapiszPlik dialog = new ZapiszPlik();

        int returnVal = dialog.showSaveDialog( this );

        if( returnVal == JFileChooser.APPROVE_OPTION ) {

            String filePath = dialog.getSelectedFile().getAbsolutePath();

            if( !dialog.getSelectedFile().getAbsolutePath().contains( ".stk" ) ) {
                filePath += ".stk";
            }

            parametry.setPlikZapisywanie( filePath );

            powiadomObserwatorow();
        }
    }

    //Akcja Otwórz Plik
    private void menuItemOtworzPlikActionPerformed(ActionEvent e) {

        OpenFile dialog = new OpenFile();

        int returnVal = dialog.showOpenDialog(this);

        if( returnVal == JFileChooser.APPROVE_OPTION ) {

            parametry.setSciezkaDoPliku( dialog.getSelectedFile().getAbsolutePath() );

            powiadomObserwatorow();

            if( parametry.getSiatka() != null ) buttonStart.setEnabled( true );
        }
    }

    //Akcja Parametry Generacji
    private void menuItemParametryGeneracjiActionPerformed(ActionEvent e) {

        WczytywanieParametrow dialog = new WczytywanieParametrow( this, parametry );

        dialog.setVisible( true );

        powiadomObserwatorow();
    }

    private void buttonStartActionPerformed(ActionEvent e) {

        Wizualizacja dialog = new Wizualizacja( this, parametry );

        dialog.dodajObserwatora( automatKomorkowy );

        dialog.setVisible( true );
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

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("WireWorld");
        setLocationByPlatform(true);
        setResizable(false);
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
                menuItemOtworzPlik.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemOtworzPlikActionPerformed(e);
                    }
                });
                menuFile.add(menuItemOtworzPlik);

                //---- menuItemZapiszDoPliku ----
                menuItemZapiszDoPliku.setText("Zapisz do pliku...");
                menuItemZapiszDoPliku.setEnabled(false);
                menuItemZapiszDoPliku.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemZapiszDoPlikuActionPerformed(e);
                    }
                });
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
                menuItemParametryGeneracji.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menuItemParametryGeneracjiActionPerformed(e);
                    }
                });
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
        buttonStart.setText("Rozpocznij animacj\u0119");
        buttonStart.setEnabled(false);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStartActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(160, Short.MAX_VALUE)
                    .addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                    .addGap(158, 158, 158))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
