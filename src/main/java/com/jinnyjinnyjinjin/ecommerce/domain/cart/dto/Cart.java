package com.jinnyjinnyjinjin.ecommerce.domain.cart.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cart {

    private Long userId;
    private Long productId;
    private int quantity;

    public static Cart of(Long userId, Long productId, int quantity) {
        return Cart.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
