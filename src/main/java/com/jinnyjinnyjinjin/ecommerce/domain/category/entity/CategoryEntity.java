package com.jinnyjinnyjinjin.ecommerce.domain.category.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "CATEGORIES")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public CategoryEntity() {
    }

    private CategoryEntity(String name,
                           String description,
                           String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
    }

    public static CategoryEntity create(String name,
                                        String description,
                                        String imageUrl) {
        return new CategoryEntity(name, description, imageUrl);
    }

    public void update(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
