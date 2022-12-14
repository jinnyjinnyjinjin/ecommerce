package com.jinnyjinnyjinjin.ecommerce.domain.token.service;

import com.jinnyjinnyjinjin.ecommerce.domain.token.entity.AuthTokenEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.token.repository.AuthTokenRepository;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class AuthTokenWriter {

    private final AuthTokenRepository authTokenRepository;

    public void write(String token, UserEntity userEntity) {
        AuthTokenEntity entity = new AuthTokenEntity(token, userEntity);
        authTokenRepository.save(entity);
    }
}
