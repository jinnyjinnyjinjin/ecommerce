package com.jinnyjinnyjinjin.ecommerce.app.auth.service;

import com.jinnyjinnyjinjin.ecommerce.app.auth.validator.AuthValidator;
import com.jinnyjinnyjinjin.ecommerce.app.user.dto.SignupDto;
import com.jinnyjinnyjinjin.ecommerce.common.utils.TokenGenerator;
import com.jinnyjinnyjinjin.ecommerce.domain.token.service.AuthTokenPersistence;
import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserPersistence userPersistence;
    private final PasswordEncoder passwordEncoder;
    private final AuthValidator authValidator;
    private final AuthTokenPersistence authTokenPersistence;

    @Transactional
    public void signup(SignupDto dto) {
        authValidator.validateEmail(dto.getEmail());
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        User user = User.of(dto.getName(), dto.getEmail(), encryptedPassword);
        Long userId = userPersistence.add(user);
        createToken(userId);
    }

    private void createToken(Long userId) {
        String token = TokenGenerator.generate();
        authTokenPersistence.add(token, userId);
    }
}
