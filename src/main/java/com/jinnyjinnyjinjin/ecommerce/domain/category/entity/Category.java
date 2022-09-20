package com.jinnyjinnyjinjin.ecommerce.domain.category.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Category() {
    }

    private Category(String name,
                     String description,
                     String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
    }

    public static Category create(String name,
                                  String description,
                                  String imageUrl) {
        return new Category(name, description, imageUrl);
    }

    public void update(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
