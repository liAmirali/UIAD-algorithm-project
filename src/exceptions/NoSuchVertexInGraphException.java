package exceptions;

public class NoSuchVertexInGraphException extends Exception {
    public NoSuchVertexInGraphException(String message) {
        super("No such vertex in graph: " + message);
    }
}
