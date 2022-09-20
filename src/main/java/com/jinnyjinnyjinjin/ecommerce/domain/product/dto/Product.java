package com.jinnyjinnyjinjin.ecommerce.domain.product.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private Long id;
    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;

    public static Product of(String name,
                      String imageUrl,
                      double price,
                      String description,
                      Long categoryId) {

        return Product.builder()
                .name(name)
                .imageUrl(imageUrl)
                .price(price)
                .description(description)
                .categoryId(categoryId)
                .build();
    }

    public static Product of(ProductEntity entity) {

        Long categoryId = entity.getCategory().getId();

        return Product.builder()
                .name(entity.getName())
                .imageUrl(entity.getImageUrl())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .categoryId(categoryId)
                .build();
    }
}
