package com.jinnyjinnyjinjin.ecommerce.domain.token.service;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthTokenPersistence {

    private final AuthTokenWriter authTokenWriter;
    private final UserReader userReader;

    public void add(String token, Long userId) {
        UserEntity user = userReader.read(userId);
        authTokenWriter.add(token, user);
    }

}
