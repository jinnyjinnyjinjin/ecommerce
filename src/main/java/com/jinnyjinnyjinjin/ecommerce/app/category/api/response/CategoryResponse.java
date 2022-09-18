package com.jinnyjinnyjinjin.ecommerce.app.category.api.response;

import com.jinnyjinnyjinjin.ecommerce.app.category.dto.CategoryDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CategoryResponse {

    private Long id;
    private String categoryName;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;

    public static CategoryResponse of(CategoryDto dto) {
        return CategoryResponse.builder()
                .id(dto.getId())
                .categoryName(dto.getName())
                .imageUrl(dto.getImageUrl())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
