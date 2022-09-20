package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CategoryWriter {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void write(Category category) {
        categoryRepository.save(category);
    }
}
