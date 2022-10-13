package com.jinnyjinnyjinjin.ecommerce.domain.token.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthToken {

    private Long id;
    private String token;
    private Long userId;

}
