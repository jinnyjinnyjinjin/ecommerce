package com.jinnyjinnyjinjin.ecommerce.app.auth.service;

import com.jinnyjinnyjinjin.ecommerce.app.auth.service.dto.SignupDto;
import com.jinnyjinnyjinjin.ecommerce.app.auth.validator.AuthValidator;
import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.AuthenticationFailException;
import com.jinnyjinnyjinjin.ecommerce.common.utils.TokenGenerator;
import com.jinnyjinnyjinjin.ecommerce.domain.token.dto.AuthToken;
import com.jinnyjinnyjinjin.ecommerce.domain.token.service.AuthPersistence;
import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthValidator authValidator;
    private final AuthPersistence authPersistence;
    private final UserPersistence userPersistence;

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

    public void authenticate(String token) {
        if (!StringUtils.hasText(token)) throw new AuthenticationFailException("유효하지 않은 토큰입니다.");
        boolean exists = authPersistence.exists(token);
        if (!exists) throw new AuthenticationFailException("토큰을 찾을 수 없습니다.");
    }

    public Long getUserId(String token) {
        AuthToken authToken = authPersistence.getAuthToken(token);
        User user = userPersistence.get(authToken.getUserId());
        return user.getId();
    }
}
