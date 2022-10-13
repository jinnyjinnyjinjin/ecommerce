package com.jinnyjinnyjinjin.ecommerce.common.exception.user;

public class UserNotFoundException extends RuntimeException {

    private final String message;
    private final Object fieldValue;

    public UserNotFoundException(String message, Object fieldValue) {
        this.message = message;
        this.fieldValue = fieldValue;
    }
}
