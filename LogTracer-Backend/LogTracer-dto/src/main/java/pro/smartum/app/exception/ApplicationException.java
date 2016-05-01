package pro.smartum.app.exception;

import pro.smartum.app.dto.ErrorCode;

/**
 * Created by eldar.s on 22.04.2016.
 */
public abstract class ApplicationException extends RuntimeException {
    public ApplicationException() {
        super();
    }

    protected ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    protected ApplicationException(Throwable cause) {
        super(cause);
    }

    protected ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    protected ApplicationException(String message) {
        super(message);
    }

    public abstract ErrorCode getErrorCode();
}
