package com.jinnyjinnyjinjin.ecommerce.common.exception.auth;

public class AuthenticationFailException extends AuthException {

    public AuthenticationFailException(String message) {
        super(message);
    }

    public AuthenticationFailException(String message, Object field) {
        super(message, field);
    }
}
