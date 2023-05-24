package exceptions;

public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String message) {
        super("Incorrect password: " + message);
    }
}
