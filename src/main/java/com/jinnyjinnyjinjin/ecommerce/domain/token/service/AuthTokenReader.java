package com.jinnyjinnyjinjin.ecommerce.domain.token.service;

import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.AuthTokenNotFound;
import com.jinnyjinnyjinjin.ecommerce.domain.token.entity.AuthTokenEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.token.repository.AuthTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Component
@RequiredArgsConstructor
public class AuthTokenReader {

    private final AuthTokenRepository authTokenRepository;

    public AuthTokenEntity findByUserId(Long userId) {
        return authTokenRepository.findByUser_Id(userId)
                .orElseThrow(() -> new AuthTokenNotFound("토큰을 찾을 수 없습니다."));
    }
}
