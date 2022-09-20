package com.jinnyjinnyjinjin.ecommerce.domain.category.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

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

    @Column(name = "category_name")
    private String name;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdAt;

    public Category() {
    }

    private Category(String name,
                    String description,
                    String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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
