package com.jinnyjinnyjinjin.ecommerce.category.dto;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
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
                .imageUrl(category.getImageUrl())
                .createdAt(category.getCreatedAt())
                .build();
    }
}