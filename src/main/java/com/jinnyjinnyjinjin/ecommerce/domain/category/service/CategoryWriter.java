package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CategoryWriter {

    private final CategoryRepository categoryRepository;

    public void write(CategoryEntity category) {
        categoryRepository.save(category);
    }
}
