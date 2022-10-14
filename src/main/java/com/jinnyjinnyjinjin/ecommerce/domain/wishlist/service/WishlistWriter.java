package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.service;

import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity.WishlistEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class WishlistWriter {

    private final WishlistRepository wishlistRepository;

    public void write(WishlistEntity entity) {
        wishlistRepository.save(entity);
    }
}
