package com.jinnyjinnyjinjin.ecommerce.app.user.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private Long id;
    private String name;
    private String email;

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
