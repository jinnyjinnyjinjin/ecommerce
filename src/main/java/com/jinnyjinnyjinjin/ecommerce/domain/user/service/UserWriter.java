package com.jinnyjinnyjinjin.ecommerce.domain.user.service;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserWriter {

    private final UserRepository userRepository;

    public Long write(UserEntity userEntity) {
        return userRepository.save(userEntity).getId();
    }
}
