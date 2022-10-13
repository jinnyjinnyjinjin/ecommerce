package com.jinnyjinnyjinjin.ecommerce.app.auth.service;

import com.jinnyjinnyjinjin.ecommerce.app.auth.validator.AuthValidator;
import com.jinnyjinnyjinjin.ecommerce.app.user.dto.SignupDto;
import com.jinnyjinnyjinjin.ecommerce.common.utils.TokenGenerator;
import com.jinnyjinnyjinjin.ecommerce.domain.token.service.AuthPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthValidator authValidator;
    private final AuthPersistence authPersistence;

    @Transactional
    public void signup(SignupDto dto) {
        authValidator.validateEmail(dto.getEmail());
        Long userId = authPersistence.addUser(dto.getName(), dto.getEmail(), dto.getPassword());
        String token = TokenGenerator.generate();
        authPersistence.addToken(token, userId);
    }

    public String signIn(String email, String password) {
        return authPersistence.getToken(email, password);
    }
}
