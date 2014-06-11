import Data.Parameters;
import GUI.MainWindow;
import Modules.CellularAutomaton;
import Modules.DataLoading;
import Modules.DataSaving;


/*
    Przepraszam, że program wygląda tak jak wygląda. Troche głupio mi to mówić, ale
    miałem problemy z czasem, aby jakoś rozsądnie zaplanowac sobie etapy budowania programu.
    Obiecuję poprawę, wraz z następnymi zajęciami (:(:
 */

public class Main {

    public static void main( String[] args ) {

        Parameters dane = new Parameters();

        MainWindow window = new MainWindow( dane );

        window.addObserver( new DataLoading() );

        window.addObserver( new DataSaving() );

        window.dodajObserwatorAutomatKomorkowy( new CellularAutomaton( dane ) );

        window.start();
    }
}
