package Modules;

import Data.Cell;
import Data.Parameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ZapisywanieDanych implements Observer {

    private FileHandling plik;
    private Parameters parameters;

    public ZapisywanieDanych() {

        this.plik = new FileHandling();
    }

    @Override
    public void update( Parameters parameters ) throws ErrorHandling {



        if( !plik.getFilePath().equals( parameters.getPathToOutputFileMesh() )  ) {

            this.parameters = parameters;

            System.out.println( "Aktualizuje moduł zapisywania plików." );

            try {

                parameters.setGeneratedMesh(parameters.getMesh());

                plik.openFile( parameters.getPathToOutputFileMesh() );
                zapiszDoPliku( parameters.getPathToOutputFileMesh() );

            } catch( IOException e ) {
                throw new ErrorHandling( e.getMessage() );
            }
        }

    }

    private void zapiszDoPliku( String sciezkaDoPliku ) throws FileNotFoundException, ErrorHandling {

        Cell cell;
        PrintWriter zapis = new PrintWriter( sciezkaDoPliku );

        zapis.println( parameters.getGeneratedMesh().getNumberOfColumns() + " " + parameters.getGeneratedMesh().getNumberOfRows() );

        for( int i=0; i < parameters.getGeneratedMesh().getNumberOfColumns(); i++ ) {

            for( int j=0; j < parameters.getGeneratedMesh().getNumberOfRows(); j++ ) {

                cell = parameters.getGeneratedMesh().getCell(i, j);
                if( cell.getStan() != 0 )
                    zapis.println( i + " " + j + " " + cell.getStan() );
            }
        }

        zapis.close();
        System.out.println( "Zapisuje dane do pliku " + sciezkaDoPliku );
    }

}
