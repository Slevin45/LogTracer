package pro.smartum.app.exception;

import pro.smartum.app.dto.ErrorCode;

/**
 * Created by eldar.s on 22.04.2016.
 */
public class UserAlreadyExistsException extends ApplicationException {
    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USER_ALREADY_EXISTST_ERROR;
    }
}
