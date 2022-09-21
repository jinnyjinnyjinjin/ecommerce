package com.jinnyjinnyjinjin.ecommerce.app.category;

import com.jinnyjinnyjinjin.ecommerce.exception.category.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = CategoryNotFoundException.class)
    public final ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
