package Data;

import Modules.ErrorHandling;

public class Mesh {

    private Cell[][] mesh;

    private int numberOfRows;
    private int numberOfColumns;

    public Mesh() {

    }


    public void makeMesh( int liczbaKolumn, int liczbaWierszy ) throws ErrorHandling { /* W tym miejscu tworzę siatke i zwracam ewentualne błędy */

        if( liczbaKolumn <= 0 || liczbaWierszy <= 0 || liczbaKolumn > 600 || liczbaWierszy > 400 ) {
            throw new ErrorHandling( "Nieprawidłwy rozmiar siatki." );
        }

        this.numberOfColumns = liczbaKolumn;
        this.numberOfRows = liczbaWierszy;

        mesh = new Cell[liczbaKolumn][liczbaWierszy];

        initMesh();

    }

    private void initMesh() { /* Tutaj wypełniam utworzoną tablicę danymi */

        int i, j;

        for( i=0; i < numberOfColumns; i++ ) {
            for( j=0; j < numberOfRows; j++ ) {
                mesh[i][j] = new Cell( 0 );
            }
        }
    }

    public void copyMesh( Mesh mesh1 ) throws ErrorHandling {

        mesh1.makeMesh(this.numberOfColumns, this.numberOfRows);

        for( int i=0; i < numberOfColumns; i++ ) {

            for( int j=0; j < numberOfRows; j++ ) {
                mesh1.setCondition(i, j, getCell(i, j).getStan());
            }
        }
    }

    /* GET FUNCTIONS */
    public Cell getCell( int x, int y ) throws ErrorHandling {

        if( x >= numberOfColumns || y >= numberOfRows ) {

            throw new ErrorHandling( "Podane współrzędne komórki znajdającej się poza zakresem siatki." );
        } else {

            return mesh[x][y];
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /* SET FUNCTIONS */
    public void setCondition( int x, int y, int stan ) throws ErrorHandling { /* Ustawiam stan dla konkretnej komórki */

        if( x >= numberOfColumns || y >= numberOfRows || x < 0 || y < 0 || stan < 0 || stan > 3 ) {
            throw new ErrorHandling( "Współrzędne komórki poza zakresem" );
        }
        else {
            mesh[x][y].setStan(stan);
        }
    }

}
