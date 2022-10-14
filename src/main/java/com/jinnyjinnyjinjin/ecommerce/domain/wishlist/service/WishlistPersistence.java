package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.service;

import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.service.ProductReader;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserReader;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.dto.Wishlist;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity.WishlistEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class WishlistPersistence {

    private final WishlistReader wishlistReader;
    private final WishlistWriter wishlistWriter;
    private final UserReader userReader;
    private final ProductReader productReader;

    public List<Wishlist> findAll(Long userId) {
        UserEntity user = userReader.read(userId);
        List<WishlistEntity> wishlists = wishlistReader.readAllByUserOrderByCreatedAtDesc(user);
        return wishlists.stream()
                .map(Wishlist::of)
                .collect(toList());
    }

    public void save(Long userId, Long productId) {
        UserEntity user = userReader.read(userId);
        ProductEntity product = productReader.read(productId);
        WishlistEntity wishlist = WishlistEntity.create(user, product);
        wishlistWriter.write(wishlist);
    }
}
