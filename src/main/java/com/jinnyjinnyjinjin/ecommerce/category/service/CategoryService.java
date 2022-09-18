package com.jinnyjinnyjinjin.ecommerce.category.service;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.category.domain.repository.CategoryRepository;
import com.jinnyjinnyjinjin.ecommerce.category.domain.service.CategoryReader;
import com.jinnyjinnyjinjin.ecommerce.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryReader categoryReader;

    public void create(String categoryName, String description, String imageUrl) {
        Category category = new Category(categoryName, description, imageUrl);
        categoryRepository.save(category);
    }

    public Page<CategoryDto> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable)
                .map(CategoryDto::of);
    }

    @Transactional
    public void update(Long id, String name, String description, String imageUrl) {
        Category category = categoryReader.findById(id);
        category.update(name, description, imageUrl);
    }
}
