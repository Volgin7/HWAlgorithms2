package sky.arraylist.exception;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
