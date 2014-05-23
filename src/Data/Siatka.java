package Data;

import Modules.ObslugaBledow;

import java.util.Observable;
import java.util.Observer;

public class Siatka implements Observer {

    private Komorka[][] siatka;

    private int liczbaWierszy;
    private int liczbaKolumn;

    public void update( Observable a, Object b ) {
        System.out.println( "saddas" + liczbaWierszy );
    }

    public Siatka( int liczbaKolumn, int liczbaWierszy ) {

        this.liczbaKolumn = liczbaKolumn;
        this.liczbaWierszy = liczbaWierszy;

        siatka = new Komorka[liczbaKolumn][liczbaWierszy];

        initializeSiatka();

    }

    private void initializeSiatka() {

        int i, j;

        for( i=0; i < liczbaKolumn; i++ ) {
            for( j=0; j < liczbaWierszy; j++ ) {
                siatka[i][j] = new Komorka( 0 );
            }
        }
    }

    public int getLiczbaWierszy() {
        return liczbaWierszy;
    }

    public int getLiczbaKolumn() {
        return liczbaKolumn;
    }

    public Komorka getKomorka(int x, int y) throws ObslugaBledow {

        if( x >= liczbaKolumn || y >= liczbaWierszy ) {
            throw new ObslugaBledow( "Podane współrzędne komórki znajdającej się poza zakresem siatki." );
        } else {
            return siatka[x][y];
        }
    }

    public void setStan( int x, int y, int stan ) throws ObslugaBledow {

        if( x >= liczbaKolumn || y >= liczbaWierszy || x < 0 || y < 0 ) throw new ObslugaBledow( "Współrzędne komórki poza zakresem" );
        else {
            siatka[x][y].stan = stan;
        }
    }
}
