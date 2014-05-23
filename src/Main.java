import Data.Siatka;
import GUI.mainWindow.MainWindow;
import Modules.ObslugaBledow;

import java.util.Observable;
import java.util.Observer;

public class Main {


    public static void a( Observer c ) {
        c.update(new Observable(), new Object() );
    }

    public static void main( String[] args ) {

        Siatka siatka = null;

        siatka = new Siatka( 100, 100 );


        try {
            siatka.setStan( 10, 10, 2);
            a(siatka);
            System.out.println(siatka.getKomorka(10, 10).stan);
        } catch ( ObslugaBledow e ) {
            System.out.println( e.toString() );
        }

        MainWindow window = new MainWindow();
        window.setVisible(true);



    }
}
