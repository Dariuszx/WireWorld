package GUI.visualisation;


import Data.Mesh;
import Modules.ErrorHandling;

import java.awt.*;

public class RysowanieSiatki extends Canvas {

    private Mesh mesh;
    private Ustawienia ustawienia;

    public RysowanieSiatki( Ustawienia ustawienia ) {

        this.ustawienia = ustawienia;
    }

    public void setMesh( Mesh mesh ) {
        this.mesh = mesh;
    }

    public void paint( Graphics g ) {

        for( int i=0; i < mesh.getNumberOfColumns(); i++ ) {

            for( int j=0; j < mesh.getNumberOfRows(); j++ ) {

                try {
                    switch( mesh.getCell(i, j).getCondition() ) {

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

                } catch( ErrorHandling e ) {
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
