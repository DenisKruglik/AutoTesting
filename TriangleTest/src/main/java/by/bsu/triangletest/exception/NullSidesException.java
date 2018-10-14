package by.bsu.triangletest.exception;

public class NullSidesException extends Exception {
    public NullSidesException() {
    }

    public NullSidesException(String message) {
        super(message);
    }

    public NullSidesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullSidesException(Throwable cause) {
        super(cause);
    }

    public NullSidesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
