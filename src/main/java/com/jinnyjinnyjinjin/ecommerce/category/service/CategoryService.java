package com.jinnyjinnyjinjin.ecommerce.category.service;

import com.jinnyjinnyjinjin.ecommerce.category.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
}
