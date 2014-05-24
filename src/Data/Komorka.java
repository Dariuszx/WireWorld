package Data;

import Modules.ObslugaBledow;

public class Komorka {

    private int stan = 0;

    public Komorka( int stan ) {

        this.stan = stan;
    }

    public int getStan() { return stan; }

    public void setStan( int stan ) throws ObslugaBledow {

        if( stan > 3 ) throw new ObslugaBledow( "Niepoprawny stan komórki." );
        this.stan = stan;
    }
}
