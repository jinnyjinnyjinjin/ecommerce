package com.jinnyjinnyjinjin.ecommerce.app.user.api.request;

import lombok.Getter;

@Getter
public class UserRegisterRequest {
    private String name;
    private String email;
    private String password;
}
