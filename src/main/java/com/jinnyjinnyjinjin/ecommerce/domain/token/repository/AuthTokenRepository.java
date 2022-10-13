package com.jinnyjinnyjinjin.ecommerce.domain.token.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.token.entity.AuthTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity, Long> {
}
