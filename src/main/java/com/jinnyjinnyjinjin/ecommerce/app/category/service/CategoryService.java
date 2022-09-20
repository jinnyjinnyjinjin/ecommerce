package com.jinnyjinnyjinjin.ecommerce.app.category.service;

import com.jinnyjinnyjinjin.ecommerce.app.category.dto.CategoryDto;
import com.jinnyjinnyjinjin.ecommerce.domain.category.service.CategoryPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public void update(Long id, String name, String description, String imageUrl) {
        categoryPersistence.update(id, name, description, imageUrl);
    }
}
