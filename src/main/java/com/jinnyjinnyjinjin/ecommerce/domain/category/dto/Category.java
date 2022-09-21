package com.jinnyjinnyjinjin.ecommerce.domain.category.dto;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Category {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime createdAt;

    public static Category of(Long id,
                                  String name,
                                  String description,
                                  String imageUrl,
                                  LocalDateTime createdAt) {
        return Category.builder()
                .id(id)
                .name(name)
                .description(description)
                .imageUrl(imageUrl)
                .createdAt(createdAt)
                .build();
    }

    public static Category of(CategoryEntity entity) {
        return Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
