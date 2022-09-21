package com.jinnyjinnyjinjin.ecommerce.domain.category.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.category.repository.CategoryRepository;
import com.jinnyjinnyjinjin.ecommerce.exception.category.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryReader {

    private final CategoryRepository categoryRepository;

    public CategoryEntity read(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("카테고리를 찾을 수 없습니다.", id));
    }

    public List<CategoryEntity> readAll() {
        return categoryRepository.findAll();
    }
}
