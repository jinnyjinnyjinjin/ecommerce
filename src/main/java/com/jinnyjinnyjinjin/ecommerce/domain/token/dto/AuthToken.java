package com.jinnyjinnyjinjin.ecommerce.domain.token.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.token.entity.AuthTokenEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthToken {

    private Long id;
    private String token;
    private Long userId;

    public static AuthToken of(AuthTokenEntity entity) {
        return AuthToken.builder()
                .id(entity.getId())
                .token(entity.getToken())
                .userId(entity.getUser().getId())
                .build();
    }
}
