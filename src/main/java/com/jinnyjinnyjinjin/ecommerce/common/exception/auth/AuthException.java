package com.jinnyjinnyjinjin.ecommerce.common.exception.auth;

public abstract class AuthException extends RuntimeException {

    private String message;
    private Object field;

    public AuthException(String message) {
        super(message);
        this.message = message;
    }

    public AuthException(String message, Object field) {
        super(message);
        this.message = message;
        this.field = field;
    }
}
