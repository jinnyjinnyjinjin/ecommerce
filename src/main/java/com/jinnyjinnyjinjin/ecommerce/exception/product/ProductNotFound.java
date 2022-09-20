package com.jinnyjinnyjinjin.ecommerce.exception.product;

public class ProductNotFound extends RuntimeException {

    private String message;
    private Object value;

    public ProductNotFound(String message, Object value) {
        this.message = message;
        this.value = value;
    }
}
