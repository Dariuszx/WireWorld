package Modules;


import Data.Mesh;

public class WyswietlSiatke {

    public WyswietlSiatke( Mesh mesh ) {

        try {
            System.out.println("Liczba kolumn = " + mesh.getNumberOfColumns() + " Liczba wierszy = " + mesh.getNumberOfRows());

            for ( int i = 0; i < mesh.getNumberOfColumns(); i++ ) {
                for ( int j = 0; j < mesh.getNumberOfRows(); j++ ) {
                    System.out.print(mesh.getCell(i, j).getCondition() + " ");
                }
                System.out.println();
            }
        } catch ( ErrorHandling e ) {

        }
    }
}
