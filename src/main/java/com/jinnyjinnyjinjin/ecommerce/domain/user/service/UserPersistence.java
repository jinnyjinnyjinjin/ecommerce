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
        UserEntity userEntity = UserEntity.create(
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
        return userWriter.write(userEntity);
    }

    public boolean existEmail(String email) {
        return userReader.exist(email);
    }
}
