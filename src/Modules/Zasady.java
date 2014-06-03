package Modules;

import Data.Cell;
import Data.Mesh;

public class Zasady {

    private Cell zadana;
    private Mesh mesh;
    private int wspolrzedneKomorkiX;
    private int wsplrzedneKomorkiY;

    public Zasady( Mesh mesh ) {

        this.mesh = mesh;
    }

    public void zmienStan( int x, int y, Cell zadana ) throws ErrorHandling {

        this.zadana = zadana;
        this.wspolrzedneKomorkiX = x;
        this.wsplrzedneKomorkiY = y;

        if( czyGlowa() ) {
            zadana.setCondition(2);

        } else if( czyOgon() ) {
            zadana.setCondition(3);

        } else if( czyPrzewodnik() ) {

            zadana.setCondition(1);
        }
    }

    private boolean czyGlowa() {

        if( zadana.getCondition() == 1 ) return true;
        return false;
    }

    private boolean czyOgon() {

        if( zadana.getCondition() == 2 ) return true;
        return false;
    }

    private boolean czyPrzewodnik() throws ErrorHandling {

        if( zadana.getCondition() != 3 ) return false;

        int x = wspolrzedneKomorkiX;
        int y = wsplrzedneKomorkiY;

        int count = 0;

        for( int x1 = -1; x1 <= 1; x1++ ) {
            for( int y1 = -1; y1 <= 1; y1++ ) {

                if( x+x1 >= 0 && y+y1 >= 0 && x+x1 < mesh.getNumberOfColumns() && y+y1 < mesh.getNumberOfRows() && ( x1 != 0 || y1 != 0 ) ) {

                    if( mesh.getCell(x + x1, y + y1).getCondition() == 1 ) {
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
