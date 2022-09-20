package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.app.category.dto.CategoryDto;
import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryPersistence {

    private final CategoryReader categoryReader;
    private final CategoryWriter categoryWriter;

    public List<Category> findAll() {
        return categoryReader.readAll();
    }

    public void save(String name, String description, String imageUrl) {
        Category category = Category.create(name, description, imageUrl);
        categoryWriter.write(category);
    }

    @Transactional
    public void update(Long id, String name, String description, String imageUrl) {
        Category category = categoryReader.read(id);
        category.update(name, description, imageUrl);
    }

    public CategoryDto findById(Long id) {
        Category category = categoryReader.read(id);
        return CategoryDto.of(category);
    }
}
