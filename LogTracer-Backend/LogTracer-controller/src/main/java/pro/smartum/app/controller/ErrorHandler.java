package pro.smartum.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.smartum.app.dto.ErrorCode;
import pro.smartum.app.dto.response.ErrorResponseBean;
import pro.smartum.app.exception.ApplicationException;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ErrorHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponseBean handleApplicationException(Exception e) {
        return handleException(e);
    }

    private ErrorResponseBean handleException(Exception e) {
        ErrorCode errorCode = getErrorCodeForException(e);
        String message = errorCode.getMessage();
        if (e.getLocalizedMessage() != null) {
            message = e.getLocalizedMessage();
        }
        return new ErrorResponseBean(errorCode.getErrorCode(), message);
    }


    private ErrorCode getErrorCodeForException(Exception e) {
        if (e instanceof ApplicationException) {
            return ((ApplicationException) e).getErrorCode();
        } else {
            return ErrorCode.INTERNAL_SERVER_ERROR;
        }
    }
}
