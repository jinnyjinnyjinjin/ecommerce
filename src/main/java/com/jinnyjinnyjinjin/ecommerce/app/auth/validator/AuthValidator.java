package com.jinnyjinnyjinjin.ecommerce.app.auth.validator;

import com.jinnyjinnyjinjin.ecommerce.common.exception.auth.SignupValidationException;
import com.jinnyjinnyjinjin.ecommerce.domain.token.service.AuthPersistence;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthValidator {

    private final UserPersistence userPersistence;
    private final AuthPersistence authPersistence;

    public void validateEmail(String email) {
        boolean exists = userPersistence.existEmail(email);
        if (exists) throw new SignupValidationException("이미 존재하는 이메일 입니다.");
    }

    public void validateToken(String token) {

    }
}
