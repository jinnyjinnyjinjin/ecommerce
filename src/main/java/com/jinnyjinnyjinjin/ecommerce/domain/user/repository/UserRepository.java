package com.jinnyjinnyjinjin.ecommerce.domain.user.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);
}
