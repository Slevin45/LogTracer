package pro.smartum.app.dto;

public enum ErrorCode {

    USER_ALREADY_EXISTST_ERROR(1, "User already exists error"),
    USER_NOT_EXISTS_ERROR(2, "User not exists"),
    UNAUTHORIZED_ACCESS_ERROR(3, "Unauthoruzed access"),
    APP_NOT_EXISTS_ERROR(4, "App not exists"),
    APP_ALREADY_EXISTS_ERROR(5, "App already exists"),
    VALIDATION_ERROR(6, "Validation error"),
    INCORRECT_USER_ERROR(7, "Incorrect user error"),
    INTERNAL_SERVER_ERROR(8, "Server error. Please, try later"),
    APPLICATION_CONFIGURATION_ERROR(9, "Application configuration error");
    private final int errorCode;
    private final String message;

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public static ErrorCode parseErrorCode(int errorCode) {
        for (ErrorCode code : values()) {
            if (code.getErrorCode() == errorCode) {
                return code;
            }
        }
        return ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}

