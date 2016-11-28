package org.babypro.exception;

/**
 * Created by johnzhu on 11/28/2016.
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
