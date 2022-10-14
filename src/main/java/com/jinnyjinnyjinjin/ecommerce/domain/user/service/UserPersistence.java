package com.jinnyjinnyjinjin.ecommerce.domain.user.service;

import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistence {

    private final UserWriter userWriter;
    private final UserReader userReader;

    public Long add(User user) {
        return userWriter.write(
                user.getEmail(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public User get(Long id) {
        UserEntity userEntity = userReader.read(id);
        return User.of(userEntity);
    }

    public boolean existEmail(String email) {
        return userReader.exist(email);
    }
}
