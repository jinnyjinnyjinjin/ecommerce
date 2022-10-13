package com.jinnyjinnyjinjin.ecommerce.domain.user.service;

import com.jinnyjinnyjinjin.ecommerce.common.exception.user.UserNotFoundException;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public UserEntity read(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", id));
    }

    public UserEntity read(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("사용자를 찾을 수 없습니다.", email));
    }

    public boolean exist(String email) {
        return userRepository.existsByEmail(email);
    }
}
