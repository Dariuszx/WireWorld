package Modules;

import java.io.File;

public class ObslugaPlikow  {

    private File plik;

    public String getFilePath() {

        if( plik == null ) return "";
        else return plik.getAbsolutePath();
    }

    public void openFile( String path ) {

        plik = null;

        plik = new File( path );
    }

    public File getPlik() {

        return plik;
    }
}
