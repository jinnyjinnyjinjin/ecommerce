package com.jinnyjinnyjinjin.ecommerce.app.auth;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.SignupValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionAdvice {

    @ExceptionHandler(SignupValidationException.class)
    public ResponseEntity<ApiResponse> handleSignupException(SignupValidationException exception) {
        return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
