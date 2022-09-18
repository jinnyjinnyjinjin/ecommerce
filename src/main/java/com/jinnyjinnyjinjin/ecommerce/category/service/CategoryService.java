package com.jinnyjinnyjinjin.ecommerce.category.service;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.category.domain.repository.CategoryRepository;
import com.jinnyjinnyjinjin.ecommerce.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void create(String categoryName, String description, String imageUrl) {
        Category category = new Category(categoryName, description, imageUrl);
        categoryRepository.save(category);
    }

    public Page<CategoryDto> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(CategoryDto::of);
    }
}
