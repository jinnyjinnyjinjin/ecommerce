package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CategoryPersistence {

    private final CategoryReader categoryReader;
    private final CategoryWriter categoryWriter;

    public Page<Category> findAll(Pageable pageable) {
        return categoryReader.readAll(pageable);
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
}
