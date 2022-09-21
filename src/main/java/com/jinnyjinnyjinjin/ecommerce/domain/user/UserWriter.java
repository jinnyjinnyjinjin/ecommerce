package com.jinnyjinnyjinjin.ecommerce.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserWriter {

    private final UserRepository userRepository;

    public void write(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
