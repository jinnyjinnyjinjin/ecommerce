package com.jinnyjinnyjinjin.ecommerce.domain.wishlist.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.product.dto.Product;
import com.jinnyjinnyjinjin.ecommerce.domain.user.dto.User;
import com.jinnyjinnyjinjin.ecommerce.domain.wishlist.entity.WishlistEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Wishlist {

    private Long id;
    private User user;
    private Product product;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Wishlist of(WishlistEntity entity) {

        User user = User.of(entity.getUser());
        Product product = Product.of(entity.getProduct());

        return Wishlist.builder()
                .id(entity.getId())
                .user(user)
                .product(product)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
