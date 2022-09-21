package com.jinnyjinnyjinjin.ecommerce.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;

    public static User of(String name, String email, String password) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
