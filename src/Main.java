import Data.Parameters;
import GUI.MainWindow;
import Modules.AutomatKomorkowy;
import Modules.DataLoading;
import Modules.DataSaving;


public class Main {

    public static void main( String[] args ) {

        Parameters dane = new Parameters();

        MainWindow window = new MainWindow( dane );

        window.addObserver(new DataLoading());

        window.addObserver(new DataSaving());

        window.dodajObserwatorAutomatKomorkowy( new AutomatKomorkowy( dane ) );

        window.start();
    }
}
