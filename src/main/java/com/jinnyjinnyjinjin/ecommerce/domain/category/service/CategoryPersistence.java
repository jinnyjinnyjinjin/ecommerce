package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.exception.CategoryNotFoundException;
import com.jinnyjinnyjinjin.ecommerce.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryPersistence {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found."));
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Transactional
    public void save(String name, String description, String imageUrl) {
        Category category = Category.create(name, description, imageUrl);
        categoryRepository.save(category);
    }
}
