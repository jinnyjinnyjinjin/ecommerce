package com.jinnyjinnyjinjin.ecommerce.app.product.api.response;

import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;

    public static ProductResponse of(ProductDto dto) {
        return ProductResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .categoryId(dto.getCategoryId())
                .build();
    }
}
