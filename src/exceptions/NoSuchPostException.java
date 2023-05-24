package exceptions;

public class NoSuchPostException extends Exception {
    public NoSuchPostException(String message) {
        super("Invalid Post ID: " + message);
    }
}
