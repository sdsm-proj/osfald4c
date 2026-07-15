package pl.org.opi.sdsm.frmwk.mechanics.exception;

public class OsfaldRuntimeException extends RuntimeException {

    public OsfaldRuntimeException(String message) {
        super(message);
    }

    public OsfaldRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
