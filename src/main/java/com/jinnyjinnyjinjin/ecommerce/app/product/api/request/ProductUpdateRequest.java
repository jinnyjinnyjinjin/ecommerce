package com.jinnyjinnyjinjin.ecommerce.app.product.api.request;

import lombok.Getter;

@Getter
public class ProductUpdateRequest {

    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;

}
