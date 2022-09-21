package com.jinnyjinnyjinjin.ecommerce.app.category.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.category.dto.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;

    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .imageUrl(category.getImageUrl())
                .createdAt(category.getCreatedAt())
                .build();
    }
}
