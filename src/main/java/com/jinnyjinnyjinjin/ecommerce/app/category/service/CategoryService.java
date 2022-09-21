package com.jinnyjinnyjinjin.ecommerce.app.category.service;

import com.jinnyjinnyjinjin.ecommerce.app.category.api.response.CategoryResponse;
import com.jinnyjinnyjinjin.ecommerce.app.category.dto.CategoryDto;
import com.jinnyjinnyjinjin.ecommerce.domain.category.dto.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.service.CategoryPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryPersistence categoryPersistence;

    public void create(String categoryName, String description, String imageUrl) {
        categoryPersistence.save(categoryName, description, imageUrl);
    }

    public List<CategoryResponse> getAll() {
        List<CategoryDto> categoryDtos = categoryPersistence.findAll().stream()
                .map(CategoryDto::of)
                .toList();
        return categoryDtos.stream()
                .map(CategoryResponse::of)
                .toList();
    }

    public void update(Long id, String name, String description, String imageUrl) {
        categoryPersistence.update(id, name, description, imageUrl);
    }

    public CategoryResponse getOne(Long id) {
        Category category = categoryPersistence.findById(id);
        CategoryDto categoryDto = CategoryDto.of(category);
        return CategoryResponse.of(categoryDto);
    }
}
