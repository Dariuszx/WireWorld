package GUI.wizualizacja;


import Data.Siatka;
import Modules.ObslugaBledow;
import Modules.WyswietlSiatke;

import java.awt.*;

public class RysowanieSiatki extends Canvas {

    private Siatka siatka;
    private Ustawienia ustawienia;

    public RysowanieSiatki( Ustawienia ustawienia ) {

        this.ustawienia = ustawienia;
    }

    public void setSiatka( Siatka siatka ) {
        this.siatka = siatka;
    }

    public void paint( Graphics g ) {

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

                    g.fillRect( ustawienia.topLeftCorner.x + i*ustawienia.szerokoscKwadratu + i,
                                    ustawienia.topLeftCorner.y + j*ustawienia.szerokoscKwadratu + j,
                                        ustawienia.szerokoscKwadratu, ustawienia.szerokoscKwadratu );

                } catch( ObslugaBledow e ) {
                    System.out.println( e.toString() );
                }
            }
        }
    }
/*
    public void update( Graphics g ) {
        paint( g );
    }
    */
}
