package Data;

import Modules.ErrorHandling;

public class Parameters {

    private int numberOfGenerations = 10;
    private int interval = 500;
    private String pathToSourceFileMesh = "";
    private String pathToOutputFileMesh = "";
    private Mesh generatedMesh;
    private Mesh mesh;

    /* Dane Automatu Komorkowego */
    private boolean generacjaStarted = false;
    private int generacjaIndex = 0;
    private Events automatKomorkowyZdarzenie = Events.NONE;


    public Parameters() {

        this.mesh = new Mesh();
        this.generatedMesh = new Mesh();
    }

    /* GET FUNCTIONS */
    public int getNumberOfGenerations() {

        return numberOfGenerations;
    }

    public int getInterval() {

        return interval;
    }

    public int getGeneracjaIndex() { return generacjaIndex; }

    public boolean getGeneracjaStarted() { return generacjaStarted; }

    public String getPathToSourceFileMesh() { return pathToSourceFileMesh; }

    public String getPathToOutputFileMesh() { return pathToOutputFileMesh; }

    public Mesh getGeneratedMesh() { return generatedMesh; }

    public Mesh getMesh() { return mesh; }

    public Events getAutomatKomorkowyZdarzenie() {

        return automatKomorkowyZdarzenie;
    }


    /* SET FUNCTIONS */
    public void setPathToOutputFileMesh( String sciezkaDoPliku ) {

        this.pathToOutputFileMesh = sciezkaDoPliku;
    }

    public void setNumberOfGenerations( int numberOfGenerations ) throws ErrorHandling {

        if( numberOfGenerations <= 0 || numberOfGenerations > 600000 ) throw new ErrorHandling( "Nieakceptowalna ilość generacji." );
        else {
            this.numberOfGenerations = numberOfGenerations;
        }
    }

    public void setInterval( int interval ) throws ErrorHandling {

        if( interval < 0 || interval > 10000 ) throw new ErrorHandling( "Nieprawidłowy odstęp czasu pomiędzy generacjami." );
        else {
            this.interval = interval;
        }
    }

    public void setPathToSourceFileMesh( String sciezka ) {
        pathToSourceFileMesh = sciezka;
    }

    public void setGeneratedMesh( Mesh mesh ) {

        this.generatedMesh = mesh;
    }

    public void setGeneracjaStarted( boolean value ) {
        generacjaStarted = value;
    }

    public void setMesh( Mesh mesh ) {

        this.mesh = mesh;
    }

    public void setGeneracjIndex( int index ) {

        this.generacjaIndex = index;
    }

    public void setAutomatKomorkowyZdarzenie( Events e ) {

        this.automatKomorkowyZdarzenie = e;
    }

}
