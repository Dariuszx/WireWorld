package Data;

import Modules.ErrorHandling;

public class Cell {

    private int stan = 0;

    public Cell( int stan ) {

        this.stan = stan;
    }

    public int getStan() { return stan; }

    public void setStan( int stan ) throws ErrorHandling {

        if( stan > 3 ) throw new ErrorHandling( "Niepoprawny stan komórki." );
        this.stan = stan;
    }
}
