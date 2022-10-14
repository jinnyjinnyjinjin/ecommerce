package com.jinnyjinnyjinjin.ecommerce.app.auth.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupDto {

    private Long id;
    private String name;
    private String email;
    private String password;

    public static SignupDto of(String name, String email, String password) {
        return SignupDto.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
