package com.jinnyjinnyjinjin.ecommerce.app.auth;

import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionAdvice {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ApiResponse> handleSignupException(AuthException exception) {
        return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
