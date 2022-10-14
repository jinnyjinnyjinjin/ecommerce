package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
    List<WishlistEntity> findAllByUserOrderByCreatedAtDesc(UserEntity user);
}
