package com.appsdeveloper.app.ws.exceptions;

import com.appsdeveloper.app.ws.exceptions.business.UserServiceException;
import com.appsdeveloper.app.ws.exceptions.messages.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request) {
        String errorMessageDescription = exception.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificException(Exception exception, WebRequest request) {
        String errorMessageDescription = exception.getLocalizedMessage();
        if (errorMessageDescription == null) errorMessageDescription = exception.toString();
        ErrorMessage errorMessage = new ErrorMessage(LocalDate.now(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
