package com.jinnyjinnyjinjin.ecommerce.domain.product.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.DateTimeEntity;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "PRODUCTS")
public class ProductEntity extends DateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    private double price;

    private String description;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    public ProductEntity() {
    }

    private ProductEntity(String name,
                         String imageUrl,
                         double price,
                         String description,
                         CategoryEntity category) {
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
                                       CategoryEntity category) {
        return new ProductEntity(
                name,
                imageUrl,
                price,
                description,
                category
        );
    }

    public void update(String name,
                       String imageUrl,
                       double price,
                       String description,
                       CategoryEntity category) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.category = category;
    }
}
