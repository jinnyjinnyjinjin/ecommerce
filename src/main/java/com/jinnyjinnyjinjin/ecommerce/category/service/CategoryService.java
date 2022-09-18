package com.jinnyjinnyjinjin.ecommerce.category.service;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.category.domain.service.CategoryPersistence;
import com.jinnyjinnyjinjin.ecommerce.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryPersistence categoryPersistence;

    public void create(String categoryName, String description, String imageUrl) {
        categoryPersistence.save(categoryName, description, imageUrl);
    }

    public Page<CategoryDto> getAll(Pageable pageable) {
        return categoryPersistence.findAll(pageable)
                .map(CategoryDto::of);
    }

    @Transactional
    public void update(Long id, String name, String description, String imageUrl) {
        Category category = categoryPersistence.findById(id);
        category.update(name, description, imageUrl);
    }
}
