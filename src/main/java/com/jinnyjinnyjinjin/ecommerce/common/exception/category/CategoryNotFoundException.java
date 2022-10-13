package com.jinnyjinnyjinjin.ecommerce.common.exception.category;

public class CategoryNotFoundException extends RuntimeException {

    private String message;
    private Object value;

    public CategoryNotFoundException(String message, Object value) {
        this.message = message;
        this.value = value;
    }
}
