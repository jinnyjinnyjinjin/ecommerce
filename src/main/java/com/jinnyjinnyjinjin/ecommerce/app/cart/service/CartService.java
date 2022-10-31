package com.jinnyjinnyjinjin.ecommerce.app.cart.service;

import com.jinnyjinnyjinjin.ecommerce.domain.cart.dto.Cart;
import com.jinnyjinnyjinjin.ecommerce.domain.cart.service.CartPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartPersistence cartPersistence;

    public void add(Long userId, Long productId, int quantity) {
        Cart cart = Cart.of(userId, productId, quantity);
        cartPersistence.create(cart);
    }
}
