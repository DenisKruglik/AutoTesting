package by.bsu.triangletest.exception;

public class InvalidSidesException extends Exception {
    public InvalidSidesException() {
    }

    public InvalidSidesException(String message) {
        super(message);
    }

    public InvalidSidesException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSidesException(Throwable cause) {
        super(cause);
    }

    public InvalidSidesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
