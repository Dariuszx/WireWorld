package Modules;

public class ErrorHandling extends Exception {

    private String message;

    public ErrorHandling( String message ) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
