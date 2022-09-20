package com.jinnyjinnyjinjin.ecommerce.app.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;

    public ProductDto of(String name,
                         String imageUrl,
                         double price,
                         String description,
                         Long categoryId) {
        return ProductDto.builder()
                .name(name)
                .imageUrl(imageUrl)
                .price(price)
                .description(description)
                .categoryId(categoryId)
                .build();
    }
}
