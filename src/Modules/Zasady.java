package Modules;

import Data.Komorka;
import Data.Siatka;

public class Zasady {

    private Komorka zadana;
    private Siatka siatka;
    private int wspolrzedneKomorkiX;
    private int wsplrzedneKomorkiY;

    public Zasady( Siatka siatka ) {

        this.siatka = siatka;
    }

    public void zmienStan( int x, int y, Komorka zadana ) throws ObslugaBledow {

        this.zadana = zadana;
        this.wspolrzedneKomorkiX = x;
        this.wsplrzedneKomorkiY = y;

        if( czyGlowa() ) {
            zadana.setStan( 2 );

        } else if( czyOgon() ) {
            zadana.setStan( 3 );

        } else if( czyPrzewodnik() ) {

            zadana.setStan( 1 );
        }
    }

    private boolean czyGlowa() {

        if( zadana.getStan() == 1 ) return true;
        return false;
    }

    private boolean czyOgon() {

        if( zadana.getStan() == 2 ) return true;
        return false;
    }

    private boolean czyPrzewodnik() throws ObslugaBledow {

        if( zadana.getStan() != 3 ) return false;

        int x = wspolrzedneKomorkiX;
        int y = wsplrzedneKomorkiY;

        int count = 0;

        for( int x1 = -1; x1 <= 1; x1++ ) {
            for( int y1 = -1; y1 <= 1; y1++ ) {

                if( x+x1 >= 0 && y+y1 >= 0 && x+x1 < siatka.getLiczbaKolumn() && y+y1 < siatka.getLiczbaWierszy() && ( x1 != 0 || y1 != 0 ) ) {

                    if( siatka.getKomorka( x+x1, y+y1 ).getStan() == 1 ) {
                        count++;
                    }
                }

            }
        }

        if( count == 1 || count == 2 ) {

            return true;
        }

        return false;
    }
}
