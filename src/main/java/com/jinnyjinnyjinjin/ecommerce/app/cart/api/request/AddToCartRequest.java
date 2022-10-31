package com.jinnyjinnyjinjin.ecommerce.app.cart.api.request;

import lombok.Getter;

@Getter
public class AddToCartRequest {
    private Long productId;
    private int quantity;
}
