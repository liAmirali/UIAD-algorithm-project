package exceptions;

public class InvalidFollowRequestException extends Exception {
    public InvalidFollowRequestException(String message) {
        super("Invalid follow request: " + message);
    }
}
