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
import GUI.editMesh.EditMesh;
import GUI.errorHandling.ErrorHandlingDialog;
import GUI.openFile.OpenFile;
import GUI.parametersLoading.ParametersLoading;
import GUI.saveFile.SaveFile;
import GUI.visualisation.Visualisation;
import GUI.yesNoDialog.YesNoDialog;
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

        setVisible(true);
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

                new ErrorHandlingDialog( this, e.toString() ).setVisible( true );
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

            parameters.setEventOccurred( Events.SAVE_FILE );

            String filePath = dialog.getSelectedFile().getAbsolutePath();

            if( !dialog.getSelectedFile().getAbsolutePath().contains( ".stk" ) ) /* Sprawdzam czy nazwa zawiera ciąg .stk, jak nie to dodaje */
            {
                filePath += ".stk";
            }

            parameters.setPathToOutputFileMesh( filePath );

            notifyObservers();
        }
    }

    private void menuItemOtworzPlikActionPerformed( ActionEvent e ) { /* Otwieram plik, aby wczytać siatkę. */

        OpenFile dialog = new OpenFile();

        int returnValue = dialog.showOpenDialog(this);

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
                    new ErrorHandlingDialog( this, error.toString() ).setVisible( true );
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

        Visualisation dialog = new Visualisation( this, parameters);

        dialog.addObserver(automatKomorkowy);

        dialog.setVisible(true);
    }

    private void buttonEdytujSiatkeActionPerformed( ActionEvent e ) {

        EditMesh dialog = new EditMesh( this, parameters );

        dialog.setVisible( true );

        notifyObservers();
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
        menuPomoc = new JMenu();
        menuItemOProgramie = new JMenuItem();
        buttonStart = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        buttonEdytujSiatke = new JButton();

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
                    public void actionPerformed( ActionEvent e ) {

                        menuItemParametryGeneracjiActionPerformed(e);
                    }
                });
                menuOpcje.add(menuItemParametryGeneracji);
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

        //---- label1 ----
        label1.setText("WireWorld");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("Wireworld to dobrze znany automat kom\u00f3rkowy zaproponowany przez Briana Silvermana.");
        label2.setVerticalAlignment(SwingConstants.TOP);
        label2.setMinimumSize(new Dimension(575, 40));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        //---- buttonEdytujSiatke ----
        buttonEdytujSiatke.setText("Edytuj siatk\u0119");
        buttonEdytujSiatke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                buttonEdytujSiatkeActionPerformed(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                        .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(buttonEdytujSiatke, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(103, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonStart, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(buttonEdytujSiatke, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                    .addContainerGap(47, Short.MAX_VALUE))
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
    private JMenu menuPomoc;
    private JMenuItem menuItemOProgramie;
    private JButton buttonStart;
    private JLabel label1;
    private JLabel label2;
    private JButton buttonEdytujSiatke;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
