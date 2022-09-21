package com.jinnyjinnyjinjin.ecommerce.app.user.service;

import com.jinnyjinnyjinjin.ecommerce.app.user.dto.SignupDto;
import com.jinnyjinnyjinjin.ecommerce.domain.user.UserPersistence;
import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistence userPersistence;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupDto dto) {
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());
        User user = User.of(dto.getName(), dto.getEmail(), encryptedPassword);
        userPersistence.add(user);
    }
}
