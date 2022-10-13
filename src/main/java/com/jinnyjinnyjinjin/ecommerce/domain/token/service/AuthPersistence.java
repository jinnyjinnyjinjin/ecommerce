package com.jinnyjinnyjinjin.ecommerce.domain.token.service;

import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.InvalidPasswordException;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserReader;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthPersistence {

    private final AuthTokenWriter authTokenWriter;
    private final AuthTokenReader authTokenReader;
    private final UserReader userReader;
    private final UserWriter userWriter;
    private final PasswordEncoder passwordEncoder;

    public Long addUser(String name, String email, String password) {
        String encoded = passwordEncoder.encode(password);
        return userWriter.write(name, email, encoded);
    }

    public void addToken(String token, Long userId) {
        UserEntity user = userReader.read(userId);
        authTokenWriter.write(token, user);
    }

    public String getToken(String email, String password) {
        UserEntity userEntity = userReader.read(email);
        boolean isValid = passwordEncoder.matches(password, userEntity.getPassword());
        if (!isValid) throw new InvalidPasswordException("잘못된 비밀번호 입니다.");
        return authTokenReader.findByUserId(userEntity.getId()).getToken();
    }
}
