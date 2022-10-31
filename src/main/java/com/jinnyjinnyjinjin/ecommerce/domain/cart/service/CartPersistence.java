package com.jinnyjinnyjinjin.ecommerce.domain.cart.service;

import com.jinnyjinnyjinjin.ecommerce.domain.cart.dto.Cart;
import com.jinnyjinnyjinjin.ecommerce.domain.cart.entity.CartEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.service.ProductReader;
import com.jinnyjinnyjinjin.ecommerce.domain.user.entity.UserEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.user.service.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartPersistence {

    private final CartWriter cartWriter;
    private final UserReader userReader;
    private final ProductReader productReader;

    @Transactional
    public void create(Cart cart) {
        UserEntity user = userReader.read(cart.getUserId());
        ProductEntity product = productReader.read(cart.getProductId());
        CartEntity cartEntity = CartEntity.create(product, cart.getQuantity(), user);
        cartWriter.write(cartEntity);
    }
}
