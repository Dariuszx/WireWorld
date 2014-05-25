import Data.Parametry;
import Data.Siatka;
import GUI.oknoGlowne.OknoGlowne;
import Modules.AutomatKomorkowy;
import Modules.WczytywanieDanych;
import Modules.ZapisywanieDanych;


public class Main {

    public static void main( String[] args ) {

        Parametry dane = new Parametry();

        OknoGlowne window = new OknoGlowne( dane );

        window.dodajObserwatora( new WczytywanieDanych() );

        window.dodajObserwatora( new ZapisywanieDanych() );

        window.dodajObserwatorAutomatKomorkowy( new AutomatKomorkowy( dane ) );

        window.setVisible(true);
    }
}
