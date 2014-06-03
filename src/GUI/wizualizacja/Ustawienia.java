package GUI.wizualizacja;


import Data.Mesh;

import java.awt.*;

public class Ustawienia {

    public Point topLeftCorner;
    public Point botRightCorner;

    public Dimension wymiaryPanelu;

    public int szerokoscKwadratu = 10;

    public Ustawienia( Mesh mesh, Dimension wymiaryPanelu ) {

        this.wymiaryPanelu = wymiaryPanelu;

        int szerokoscSiatki = mesh.getNumberOfColumns() * szerokoscKwadratu + mesh.getNumberOfColumns();
        int wysokoscSiatki = mesh.getNumberOfRows() * szerokoscKwadratu + mesh.getNumberOfRows();

        topLeftCorner = new Point( (wymiaryPanelu.width - szerokoscSiatki) / 2, (wymiaryPanelu.height - wysokoscSiatki) / 2 );
        botRightCorner = new Point( topLeftCorner.x + szerokoscSiatki, topLeftCorner.y + wysokoscSiatki );

    }

    public Dimension pobierzWspolrzedne( int x, int y ) {

        if( x < topLeftCorner.x || x > botRightCorner.x || y < topLeftCorner.y || y > botRightCorner.y ) {

            System.out.println( "Źle" );
            return null;
        } else {
            System.out.println( "Dobrze" );
        }

        return null;


    }

}
