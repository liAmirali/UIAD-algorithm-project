package exceptions;

public class ProfileViewPermissionException extends Exception {
    public ProfileViewPermissionException(String message) {
        super("ProfileViewPermissionException: " + message);
    }
}
