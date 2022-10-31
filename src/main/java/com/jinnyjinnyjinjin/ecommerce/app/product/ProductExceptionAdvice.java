package com.jinnyjinnyjinjin.ecommerce.app.product;

import com.jinnyjinnyjinjin.ecommerce.app.ApiResponse;
import com.jinnyjinnyjinjin.ecommerce.common.exception.product.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionAdvice {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
