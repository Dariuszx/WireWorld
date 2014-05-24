package Modules;

import Data.Komorka;
import Data.Parametry;
import Data.Siatka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ZapisywanieDanych implements Observer {

    private ObslugaPlikow plik;
    private Parametry parametry;

    public ZapisywanieDanych() {

        this.plik = new ObslugaPlikow();
    }

    @Override
    public void update( Parametry parametry ) throws ObslugaBledow {

        if( !plik.getFilePath().equals( parametry.getPlikZapisywanie() ) && parametry.getWygenerowanaSiatka() != null ) {

            this.parametry = parametry;

            System.out.println( "Aktualizuje moduł zapisywania plików." );

            try {

                plik.openFile( parametry.getPlikZapisywanie() );
                zapiszDoPliku( parametry.getPlikZapisywanie() );

            } catch( IOException e ) {
                throw new ObslugaBledow( e.getMessage() );
            }
        }

    }

    private void zapiszDoPliku( String sciezkaDoPliku ) throws FileNotFoundException, ObslugaBledow {

        Komorka komorka;
        PrintWriter zapis = new PrintWriter( sciezkaDoPliku );

        zapis.println( parametry.getWygenerowanaSiatka().getLiczbaKolumn() + " " + parametry.getWygenerowanaSiatka().getLiczbaWierszy() );

        for( int i=0; i < parametry.getWygenerowanaSiatka().getLiczbaKolumn(); i++ ) {

            for( int j=0; j < parametry.getWygenerowanaSiatka().getLiczbaWierszy(); j++ ) {

                komorka = parametry.getWygenerowanaSiatka().getKomorka( i, j );
                if( komorka.getStan() != 0 )
                    zapis.println( i + " " + j + " " + komorka.getStan() );
            }
        }

        zapis.close();
        System.out.println( "Zapisuje dane do pliku " + sciezkaDoPliku );
    }

}
