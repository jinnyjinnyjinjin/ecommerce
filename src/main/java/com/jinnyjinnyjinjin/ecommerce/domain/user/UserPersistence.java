package com.jinnyjinnyjinjin.ecommerce.domain.user;

import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPersistence {

    private final UserWriter userWriter;

    public void add(User user) {
        UserEntity userEntity = UserEntity.create(user.getName(), user.getEmail(), user.getPassword());
        userWriter.write(userEntity);
    }
}
