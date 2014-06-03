package Modules;

import java.io.File;
import java.io.IOException;

public class FileHandling {

    private File file;


    public void openFile( String path ) throws IOException {

        file = null;

        file = new File( path );

        if( !file.exists() ) {
            file.createNewFile();
        }
    }

    public String getFilePath() {

        if( file == null ) return "";
        else return file.getAbsolutePath();
    }

    public File getFile() {

        return file;
    }

}
