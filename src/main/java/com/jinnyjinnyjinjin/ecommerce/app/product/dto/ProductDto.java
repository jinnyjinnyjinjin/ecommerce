package com.jinnyjinnyjinjin.ecommerce.app.product.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.product.dto.Product;
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

    public static ProductDto of(String name,
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

    public static ProductDto of(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .description(product.getDescription())
                .categoryId(product.getCategoryId())
                .build();
    }
}
