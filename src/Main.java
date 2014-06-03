import Data.Parameters;
import GUI.oknoGlowne.OknoGlowne;
import Modules.AutomatKomorkowy;
import Modules.DataLoading;
import Modules.ZapisywanieDanych;


public class Main {

    public static void main( String[] args ) {

        Parameters dane = new Parameters();

        OknoGlowne window = new OknoGlowne( dane );

        window.dodajObserwatora( new DataLoading() );

        window.dodajObserwatora( new ZapisywanieDanych() );

        window.dodajObserwatorAutomatKomorkowy( new AutomatKomorkowy( dane ) );

        window.setVisible(true);
    }
}
