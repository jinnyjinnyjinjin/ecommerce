package com.jinnyjinnyjinjin.ecommerce.domain.category.entity;

import com.jinnyjinnyjinjin.ecommerce.domain.common.DateTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "CATEGORIES")
public class CategoryEntity extends DateTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    public CategoryEntity() {
    }

    private CategoryEntity(String name,
                           String description,
                           String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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
