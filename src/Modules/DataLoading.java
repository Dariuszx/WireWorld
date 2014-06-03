package Modules;

import Data.Events;
import Data.Mesh;
import Data.Parameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DataLoading implements Observer {

    private FileHandling file;

    public DataLoading() {

        this.file = new FileHandling( );
    }

    @Override
    public void update( Parameters parameters ) throws ErrorHandling {

        //Sprawdzam czy użytkownik rząda otwarcia pliku
        if ( parameters.getEventOccurred() == Events.OPEN_FILE ) {

            try {

                parameters.getMesh().setLoaded( false );

                //Muszę na nowo otworzyć plik
                file.openFile( parameters.getPathToSourceFileMesh() );

                loadData( parameters.getMesh() );

                //Kopiuję wczytaną siatkę do siatki przechowującą generacje
                parameters.getMesh().copyMesh( parameters.getGeneratedMesh() );

                parameters.setEventOccurred( Events.NONE ); /* Wykonałem wymagane operacje, ustawiam na NULL */

                parameters.getMesh().setLoaded( true );

            } catch( NumberFormatException e ) {
                throw new ErrorHandling( e.toString() );
            } catch( FileNotFoundException e ) {
                throw  new ErrorHandling( e.toString() );
            } catch( IOException e ) {
                throw new ErrorHandling( e.toString() );
            }

        }
    }

    private void loadData( Mesh mesh ) throws ErrorHandling, NumberFormatException, FileNotFoundException {

        Scanner sc;

        int lineIndex = 0; /* Zmienna zliczając kolejne wiersze w pliku */

        sc = new Scanner( file.getFile() );

        while ( sc.hasNextLine() ) {

            if( lineIndex == 0 ) /* Jeżeli pierwszy wiersz, to zczytuje rozmiary siatki */
            {
                loadHeader(mesh, sc.nextLine());
            }
            else /* Kolejne wiersze pliku to współrzędne na siatce z odpowiednim stanem np. [10 4 2] czyli wsp. (10,4) stan=2 */
            {
                loadSpecifiedCell(mesh, sc.nextLine());
            }
            lineIndex++; /* Zwiększam licznik wierszy */
        }

        sc.close(); /* Zamykam uchwyt */

    }

    private void loadHeader( Mesh mesh, String header ) throws ErrorHandling, NumberFormatException {

        Scanner row = new Scanner( header );

        int x=0, y=0;

        int wordIndex = 0; /* Licznik wczytanych wyrazów */

        while( row.hasNext() ) {

            if( wordIndex == 0 )
            {
                x = Integer.parseInt(row.next());
            }
            else if ( wordIndex == 1 )
            {
                y = Integer.parseInt(row.next());
            }
            else break;

            wordIndex++;
        }

        mesh.makeMesh(x, y);

        row.close();
    }

    private void loadSpecifiedCell( Mesh mesh, String line ) throws ErrorHandling, NumberFormatException {

        Scanner row = new Scanner( line );

        int wordIndex = 0; /* Licznik słów */
        int x=0, y=0, condition=0;

        while( row.hasNext() ) {

            if( wordIndex == 0 ) x = Integer.parseInt( row.next() );
            else if( wordIndex == 1 ) y = Integer.parseInt( row.next() );
            else if( wordIndex == 2 ) condition = Integer.parseInt( row.next() );
            else break;

            wordIndex++;
        }

        mesh.setCondition(x, y, condition); /* Ustawiam konkretny stan komórki na konkretnej pozycji */

        row.close();
    }
}
