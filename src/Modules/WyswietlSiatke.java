package Modules;


import Data.Siatka;

public class WyswietlSiatke {

    public WyswietlSiatke( Siatka siatka ) {

        try {
            System.out.println("Liczba kolumn = " + siatka.getLiczbaKolumn() + " Liczba wierszy = " + siatka.getLiczbaWierszy());

            for ( int i = 0; i < siatka.getLiczbaKolumn(); i++ ) {
                for ( int j = 0; j < siatka.getLiczbaWierszy(); j++ ) {
                    System.out.print(siatka.getKomorka(i, j).getStan() + " ");
                }
                System.out.println();
            }
        } catch ( ObslugaBledow e ) {

        }
    }
}
