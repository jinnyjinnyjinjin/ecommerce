package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.dto.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryPersistence {

    private final CategoryReader categoryReader;
    private final CategoryWriter categoryWriter;

    public List<Category> findAll() {
        List<CategoryEntity> categories = categoryReader.readAll();
        return categories.stream()
                .map(Category::of)
                .toList();
    }

    public void save(String name, String description, String imageUrl) {
        CategoryEntity category = CategoryEntity.create(name, description, imageUrl);
        categoryWriter.write(category);
    }

    public void update(Long id, String name, String description, String imageUrl) {
        CategoryEntity category = categoryReader.read(id);
        category.update(name, description, imageUrl);
        categoryWriter.write(category);
    }

    public Category findById(Long id) {
        CategoryEntity category = categoryReader.read(id);
        return Category.of(category);
    }
}
