package com.jinnyjinnyjinjin.ecommerce.app.product.api.request;

import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCreateRequest {

    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;

    public ProductDto toDto(String name,
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
