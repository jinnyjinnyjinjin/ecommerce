package com.jinnyjinnyjinjin.ecommerce.app.auth.api.request;

import lombok.Getter;

@Getter
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
}
