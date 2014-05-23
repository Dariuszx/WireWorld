package Data;

import Modules.ObslugaBledow;

public class Parametry {

    private int iloscGeneracji = 0;
    private int odstepCzasu = 0;

    public Parametry( int iloscGeneracji, int odstepCzasu ) {

        this.iloscGeneracji = iloscGeneracji;
        this.odstepCzasu = odstepCzasu;
    }

    public Parametry() { }

    public int getIloscGeneracji() {
        return iloscGeneracji;
    }

    public int getOdstepCzasu() {
        return odstepCzasu;
    }

    public void setIloscGeneracji( int iloscGeneracji ) throws ObslugaBledow {

        if( iloscGeneracji <= 0 || iloscGeneracji > 600000 ) throw new ObslugaBledow( "Nieakceptowalna ilość generacji." );
        else {
            this.iloscGeneracji = iloscGeneracji;
        }
    }

    public void setOdstepCzasu( int odstepCzasu ) throws ObslugaBledow {

        if( odstepCzasu < 0 || odstepCzasu > 10000 ) throw new ObslugaBledow( "Nieprawidłowy odstęp czasu pomiędzy generacjami." );
        else {
            this.odstepCzasu = odstepCzasu;
        }
    }
}
