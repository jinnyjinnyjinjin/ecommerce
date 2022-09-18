package com.jinnyjinnyjinjin.ecommerce.category.domain.service;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.category.domain.exception.CategoryException;
import com.jinnyjinnyjinjin.ecommerce.category.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryReader {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryException("카테고리를 찾을 수 없습니다."));
    }
}
