package com.jinnyjinnyjinjin.ecommerce.domain.user.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
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

    public static User of(String name, String email) {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }

    public static User of(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
