package Data;

import Modules.ErrorHandling;

public class Parameters {

    private int numberOfGenerations = 10;
    private int interval = 500;
    private int indexOfGenerations = 0;
    private String pathToSourceFileMesh = "";
    private String pathToOutputFileMesh = "";
    private Events eventOccurred = Events.NONE;
    private Mesh generatedMesh;
    private Mesh mesh;


    private boolean generacjaStarted = false;



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

    public int getIndexOfGenerations() { return indexOfGenerations; }

    public boolean getGeneracjaStarted() { return generacjaStarted; }

    public boolean getIsMeshLoaded() {

        return mesh.getLoaded();
    }

    public String getPathToSourceFileMesh() { return pathToSourceFileMesh; }

    public String getPathToOutputFileMesh() { return pathToOutputFileMesh; }

    public Mesh getGeneratedMesh() { return generatedMesh; }

    public Mesh getMesh() { return mesh; }

    public Events getEventOccurred() {

        return eventOccurred;
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

        this.indexOfGenerations = index;
    }

    public void setEventOccurred( Events e ) {

        this.eventOccurred = e;
    }

}
