package pro.smartum.app.exception;

import pro.smartum.app.dto.ErrorCode;

/**
 * Created by eldar.s on 26.04.2016.
 */
public class IncorrectUserException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.INCORRECT_USER_ERROR;
    }
}
