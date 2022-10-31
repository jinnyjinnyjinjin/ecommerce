package com.jinnyjinnyjinjin.ecommerce.domain.cart.service;

import com.jinnyjinnyjinjin.ecommerce.domain.cart.entity.CartEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartWriter {

    private final CartRepository cartRepository;

    public void write(CartEntity entity) {
        cartRepository.save(entity);
    }
}
