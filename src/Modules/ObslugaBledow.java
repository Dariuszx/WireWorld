package Modules;

public class ObslugaBledow extends Exception {

    private String message;

    public ObslugaBledow( String message ) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
