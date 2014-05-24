import Data.Parametry;
import Data.Siatka;
import GUI.oknoGlowne.OknoGlowne;
import Modules.WczytywanieDanych;


public class Main {

    public static void main( String[] args ) {

        Siatka siatka = null;
        Parametry parametry = new Parametry();

        OknoGlowne window = new OknoGlowne( parametry );

        window.dodajObserwatora( new WczytywanieDanych( siatka ) );

        window.setVisible(true);



    }
}
