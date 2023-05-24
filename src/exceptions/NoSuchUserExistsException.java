package exceptions;

public class NoSuchUserExistsException extends Exception {
    public NoSuchUserExistsException(String message) {
        super("Non-existing username: " + message);
    }
}
