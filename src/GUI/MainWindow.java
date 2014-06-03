/*
 * Created by JFormDesigner on Thu May 22 20:41:12 CEST 2014
 */

package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

import Data.Events;
import Data.Parameters;
import GUI.openFile.OpenFile;
import GUI.parametersLoading.ParametersLoading;
import GUI.saveFile.SaveFile;
import GUI.visualisation.Wizualizacja;
import GUI.yesNoDialog.YesNoDialog;
import GUI.obslugaBledow.ObslugaBledowDialog;
import Modules.ErrorHandling;
import Modules.Observable;
import Modules.Observer;


public class MainWindow extends JFrame implements Observable, Observer {

    private ArrayList<Observer> observers;
    private Parameters parameters;

    private Observer automatKomorkowy;

    public MainWindow( Parameters parameters ) {

        this.parameters = parameters;
        this.observers = new ArrayList<Observer>();

        initComponents();
        
    }

    public void start() {

        addObserver( this );

        notifyObservers();

        setVisible( true );
    }

    public void dodajObserwatorAutomatKomorkowy( Observer automatKomorkowy ) {

        this.automatKomorkowy = automatKomorkowy;
    }

    @Override
    public void addObserver( Observer o ) {

        observers.add(o);
    }

    @Override
    public void removeObserver( Observer o ) {

        int index = observers.indexOf(o);
        observers.remove(index);
    }

    @Override
    public void notifyObservers() {

        for( Observer o : observers ) {
            try {

                o.update(parameters);
            } catch ( ErrorHandling e ) {

                new ObslugaBledowDialog( this, e.toString() ).setVisible( true );
            }
        }
    }

    @Override
    public void update( Parameters parameters ) throws ErrorHandling {

        if( parameters.getIsMeshLoaded() )
        {
            buttonStart.setEnabled( true );
            menuItemZapiszDoPliku.setEnabled( true );
            menuItemParametryGeneracji.setEnabled( true );
        }
        else
        {
            buttonStart.setEnabled( false );
            menuItemZapiszDoPliku.setEnabled( false );
            menuItemParametryGeneracji.setEnabled( false );
        }


    }

    private void menuItemExitActionPerformed( ActionEvent e ) {

        closingOperation();
    }

    private void menuItemZapiszDoPlikuActionPerformed( ActionEvent e ) { /* Zapisywanie danych do pliku */

        SaveFile dialog = new SaveFile();

        int returnValue = dialog.showSaveDialog( this );

        if( returnValue == JFileChooser.APPROVE_OPTION ) {

            String filePath = dialog.getSelectedFile().getAbsolutePath();

            if( !dialog.getSelectedFile().getAbsolutePath().contains( ".stk" ) )
            {
                filePath += ".stk";
            }

            parameters.setPathToOutputFileMesh( filePath );

            notifyObservers();
        }
    }

    private void menuItemOtworzPlikActionPerformed( ActionEvent e ) { /* Otwieram plik, aby wczytać siatkę. */

        OpenFile dialog = new OpenFile();

        int returnValue = dialog.showOpenDialog( this );

        if( returnValue == JFileChooser.APPROVE_OPTION ) {

            parameters.setPathToSourceFileMesh( dialog.getSelectedFile().getAbsolutePath() ); /* Ustawiam wczytany plik. */

            parameters.setEventOccurred( Events.OPEN_FILE );

            notifyObservers(); /* Powiadamiam obserwatorów o zmianach */

            if( parameters.getIsMeshLoaded() ) /* Jeżeli wczytano siatkę */
            {

                try
                {
                    parameters.getMesh().copyMesh( parameters.getGeneratedMesh() ); /* Kopiuję otwartą siatke do tej, z której będe tworzył generacje */
                    menuItemZapiszDoPliku.setEnabled( true ); /* Włączam możliwość zapisania danych do pliku. */
                }
                catch ( ErrorHandling error )
                {
                    new ObslugaBledowDialog( this, error.toString() ).setVisible( true );
                }

            }
        }
    }

    private void menuItemParametryGeneracjiActionPerformed( ActionEvent e ) { /* Menu, w którym określam parametry generacji */

        ParametersLoading dialog = new ParametersLoading( this, parameters );

        dialog.setVisible( true );

        notifyObservers();
    }

    private void buttonStartActionPerformed( ActionEvent e ) { /* Otwieram okno Automatu Komórkowego */

        Wizualizacja dialog = new Wizualizacja( this, parameters);

        dialog.addObserver(automatKomorkowy);

        dialog.setVisible( true );
    }

    private void thisWindowClosing( WindowEvent e ) {

        closingOperation();
    }

    private void closingOperation() {

        YesNoDialog dialog = new YesNoDialog( this );
        dialog.setVisible(true);

        if( dialog.getOptionSelected() ) close();
    }

    private void close() {

        this.setVisible( false );
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
                menuItemParametryGeneracji.setText("Parameters generacji");
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
