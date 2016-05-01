package pro.smartum.app.exception;

import pro.smartum.app.dto.ErrorCode;

/**
 * Created by eldar.s on 25.04.2016.
 */
public class AppAlreadyExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.APP_ALREADY_EXISTS_ERROR;
    }
}
