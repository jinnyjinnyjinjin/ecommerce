package com.jinnyjinnyjinjin.ecommerce.app.wishlist.service;

import com.jinnyjinnyjinjin.ecommerce.app.wishlist.dto.WishlistDto;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.dto.Wishlist;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.service.WishlistPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistPersistence wishlistPersistence;

    public List<WishlistDto> findAll(Long userId) {
        List<Wishlist> wishlist = wishlistPersistence.findAll(userId);
        return wishlist.stream()
                .map(WishlistDto::of)
                .collect(toList());
    }

    public void create(Long userId, Long productId) {
        wishlistPersistence.save(userId, productId);
    }
}
