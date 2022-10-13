package com.jinnyjinnyjinjin.ecommerce.app.category.api;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiResponse {

    private final boolean success;
    private final String message;

    public ApiResponse(boolean isSuccess, String message) {
        this.success = isSuccess;
        this.message = message;
    }

    public String getTimestamp() {
        return LocalDateTime.now().toString();
    }
}
