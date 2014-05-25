package Data;

import Modules.ObslugaBledow;

public class Siatka {

    private Komorka[][] siatka;

    private int liczbaWierszy;
    private int liczbaKolumn;

    public Siatka( int liczbaKolumn, int liczbaWierszy ) throws ObslugaBledow {

        if( liczbaKolumn <= 0 || liczbaWierszy <= 0 || liczbaKolumn > 10000 || liczbaWierszy > 10000 ) {
            throw new ObslugaBledow( "Nieprawidłowy rozmiar siatki" );
        }

        this.liczbaKolumn = liczbaKolumn;
        this.liczbaWierszy = liczbaWierszy;

        siatka = new Komorka[liczbaKolumn][liczbaWierszy];

        initializeSiatka();

    }

    public Siatka() {

    }

    public void stworzSiatke(int liczbaKolumn, int liczbaWierszy ) throws ObslugaBledow {

        if( liczbaKolumn <= 0 || liczbaWierszy <= 0 || liczbaKolumn > 10000 || liczbaWierszy > 10000 ) {
            throw new ObslugaBledow( "Nieprawidłowy rozmiar siatki" );
        }

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

        if( x >= liczbaKolumn || y >= liczbaWierszy || x < 0 || y < 0 || stan < 0 || stan > 3 ) throw new ObslugaBledow( "Współrzędne komórki poza zakresem" );
        else {
            siatka[x][y].setStan( stan );
        }
    }

    public void kopiujSiatke( Siatka siatka1 ) throws ObslugaBledow {

        siatka1.stworzSiatke( this.liczbaKolumn, this.liczbaWierszy );

        for( int i=0; i < liczbaKolumn; i++ ) {

            for( int j=0; j < liczbaWierszy; j++ ) {
                siatka1.setStan( i,j, getKomorka(i,j).getStan() );
            }
        }
    }
}
