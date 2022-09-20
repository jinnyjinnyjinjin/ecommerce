package com.jinnyjinnyjinjin.ecommerce.domain.product.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    private double price;

    private String description;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public ProductEntity() {
    }

    public ProductEntity(String name,
                         String imageUrl,
                         double price,
                         String description,
                         Category category) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public static ProductEntity create(String name,
                                       String imageUrl,
                                       double price,
                                       String description,
                                       Category category) {
        return new ProductEntity(
                name,
                imageUrl,
                price,
                description,
                category
        );
    }
}
