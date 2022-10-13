package com.jinnyjinnyjinjin.ecommerce.domain.token.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.token.entity.AuthTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity, Long> {
    Optional<AuthTokenEntity> findByUser_Id(Long userId);
}
