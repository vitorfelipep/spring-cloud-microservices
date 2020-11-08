package com.appsdeveloper.app.ws.exceptions.business;

public class UserServiceException extends RuntimeException {

    private static final long serialVersionUID = -1010294792908677191L;

    public UserServiceException(String message) {
        super(message);
    }
}
