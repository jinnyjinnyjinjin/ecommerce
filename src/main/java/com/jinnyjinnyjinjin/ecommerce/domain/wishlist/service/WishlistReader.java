package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.service;

import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity.WishlistEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WishlistReader {

    private final WishlistRepository wishlistRepository;

    public List<WishlistEntity> readAllByUserOrderByCreatedAtDesc(UserEntity user) {
        return wishlistRepository.findAllByUserOrderByCreatedAtDesc(user);
    }
}
