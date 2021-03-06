package Modules;

import Data.Cell;
import Data.Events;
import Data.Parameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class DataSaving implements Observer {

    private FileHandling file;
    private Parameters parameters;

    public DataSaving() {

        this.file = new FileHandling();
    }

    @Override
    public void update( Parameters parameters ) throws ErrorHandling {

        if( parameters.getEventOccurred() == Events.SAVE_FILE ) {

            this.parameters = parameters;

            try {

                //parameters.setGeneratedMesh(parameters.getMesh());

                file.openFile( parameters.getPathToOutputFileMesh() );

                saveToFile(parameters.getPathToOutputFileMesh());

            } catch( IOException e ) {
                throw new ErrorHandling( e.getMessage() );
            }
        }

    }

    private void saveToFile( String pathToFile ) throws FileNotFoundException, ErrorHandling {

        Cell cell;
        PrintWriter zapis = new PrintWriter( pathToFile );

        zapis.println( parameters.getGeneratedMesh().getNumberOfColumns() + " " + parameters.getGeneratedMesh().getNumberOfRows() );

        for( int i=0; i < parameters.getGeneratedMesh().getNumberOfColumns(); i++ )
        {

            for( int j=0; j < parameters.getGeneratedMesh().getNumberOfRows(); j++ )
            {

                cell = parameters.getGeneratedMesh().getCell(i, j);
                if( cell.getCondition() != 0 )
                    zapis.println( i + " " + j + " " + cell.getCondition() );
            }
        }

        zapis.close();
    }

}
