package Modules;

import java.io.File;
import java.io.IOException;

public class ObslugaPlikow  {

    private File plik;

    public String getFilePath() {

        if( plik == null ) return "";
        else return plik.getAbsolutePath();
    }

    public void openFile( String path ) throws IOException {

        plik = null;

        plik = new File( path );

        if( !plik.exists() ) {
            plik.createNewFile();
        }
    }

    public File getPlik() {

        return plik;
    }
}
