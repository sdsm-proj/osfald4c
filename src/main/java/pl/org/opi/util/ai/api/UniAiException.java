package pl.org.opi.util.ai.api;

public class UniAiException extends RuntimeException {

    public UniAiException(String message) {
        super(message);
    }

    public UniAiException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniAiException(Throwable cause) {
        super(cause);
    }

}
