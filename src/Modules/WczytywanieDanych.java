package Modules;

import Data.Parametry;
import Data.Siatka;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WczytywanieDanych implements Observer {

    private Siatka siatka;
    private ObslugaPlikow plik;

    public WczytywanieDanych( Siatka siatka ) {

        this.siatka = siatka;
        this.plik = new ObslugaPlikow( );
    }

    @Override
    public void update( Parametry parametry ) throws ObslugaBledow {

        //Sprawdzam czy zmieniła się ścieżka do pliku, jeżeli tak to na nowo wczytuję dane
        if ( !parametry.getSciezkaDoPliku().equals( plik.getFilePath() ) ) {

            System.out.println( "Aktualizacja WczytywanieDanych" );

            try {
                //Muszę na nowo otworzyć plik
                plik.openFile( parametry.getSciezkaDoPliku() );

                siatka = null; //Zeruję siatkę

                wczytajDane();

                parametry.setWygenerowanaSiatka( siatka );

            } catch( NumberFormatException e ) {
                throw new ObslugaBledow( e.toString() );
            } catch( FileNotFoundException e ) {
                throw  new ObslugaBledow( e.toString() );
            } catch( IOException e ) {
                throw new ObslugaBledow( e.toString() );
            }

        }
    }

    private void wczytajDane() throws ObslugaBledow, NumberFormatException, FileNotFoundException {

        Scanner sc;

        int lineIndex = 0;

        sc = new Scanner(plik.getPlik());

        while ( sc.hasNextLine() ) {

            if( lineIndex == 0 ) { // Pierwszy wiersz pliku to rozmiary siatki
                wczytajNaglowek(sc.nextLine());
            } else { //Zaś kolejne wiersze pliku to współrzędne na siatce z odpowiednim stanem np. [10 4 2] czyli wsp. (10,4) stan=2
                wczytajKomorke( sc.nextLine() );
            }
            lineIndex++;
        }

        sc.close();
    }

    private void wczytajNaglowek( String naglowek ) throws ObslugaBledow, NumberFormatException {

        Scanner wiersz = new Scanner( naglowek );

        int x=0, y=0;

        int wordIndex = 0;

        while( wiersz.hasNext() ) {

            if( wordIndex == 0 ) {
                x = Integer.parseInt( wiersz.next() );
            } else if ( wordIndex == 1 ) {
                y = Integer.parseInt( wiersz.next() );
            } else break;

            wordIndex++;
        }

        siatka = new Siatka( x, y );

        System.out.println( "X=" + x + " Y=" + y );
        wiersz.close();

    }

    private void wczytajKomorke( String linia ) throws ObslugaBledow, NumberFormatException {

        Scanner wiersz = new Scanner( linia );

        int wordIndex = 0;
        int x=0, y=0, stan=0;

        while( wiersz.hasNext() ) {

            if( wordIndex == 0 ) x = Integer.parseInt( wiersz.next() );
            else if( wordIndex == 1 ) y = Integer.parseInt( wiersz.next() );
            else if( wordIndex == 2 ) stan = Integer.parseInt( wiersz.next() );
            else break;

            wordIndex++;
        }

        siatka.setStan( x, y, stan );

        System.out.println( "x=" + x + " y=" + y + " stan=" + stan );

        wiersz.close();
    }
}
