package GUI.wizualizacja;


import Data.Siatka;
import Modules.ObslugaBledow;
import Modules.WyswietlSiatke;

import java.awt.*;

public class RysowanieSiatki extends Canvas {

    private Siatka siatka;
    private int kwadratWymiary;

    public RysowanieSiatki( Siatka siatka ) {

        this.siatka = siatka;
        obliczPreferowanaSzerokoscKwadratu();
    }

    private void obliczPreferowanaSzerokoscKwadratu() {

        if( siatka.getLiczbaKolumn() > siatka.getLiczbaWierszy() ) {
            kwadratWymiary = 616 / siatka.getLiczbaKolumn();
        } else {
            kwadratWymiary = 406 / siatka.getLiczbaWierszy();
        }
    }

    public void paint(Graphics g) {

        int centerX = ( 610 - ( siatka.getLiczbaKolumn() * kwadratWymiary ) ) / 2;
        int centerY = ( 410 - ( siatka.getLiczbaWierszy() * kwadratWymiary ) ) / 2;

        for( int i=0; i < siatka.getLiczbaKolumn(); i++ ) {

            for( int j=0; j < siatka.getLiczbaWierszy(); j++ ) {

                try {
                    switch( siatka.getKomorka( i, j ).getStan() ) {

                        case 0:
                            g.setColor(Color.black);

                            break;
                        case 1:
                            g.setColor(Color.blue);
                            break;

                        case 2:
                            g.setColor(Color.red);
                            break;

                        case 3:
                            g.setColor(Color.yellow);
                            break;
                    }

                    g.fillRect(centerX + i*kwadratWymiary, centerY + j*kwadratWymiary, kwadratWymiary, kwadratWymiary );

                } catch( ObslugaBledow e ) {
                    System.out.println( e.toString() );
                }
            }
        }
    }

    public void update( Graphics g ) {
        paint( g );
    }
}
