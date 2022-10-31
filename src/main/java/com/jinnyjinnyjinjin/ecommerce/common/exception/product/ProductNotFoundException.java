package com.jinnyjinnyjinjin.ecommerce.common.exception.product;

public class ProductNotFoundException extends RuntimeException {

    private String message;
    private Object value;

    public ProductNotFoundException(String message, Object value) {
        super(message);
        this.message = message;
        this.value = value;
    }
}
