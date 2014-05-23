package Modules;

import Data.Siatka;

public class WczytywanieDanych {

    private Siatka siatka;
    private ObslugaPlikow plik;

    public WczytywanieDanych( Siatka siatka ) {

        this.siatka = siatka;
        this.plik = new ObslugaPlikow();
    }


}
