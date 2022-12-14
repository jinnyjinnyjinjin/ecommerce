package com.jinnyjinnyjinjin.ecommerce.domain.product.service;

import com.jinnyjinnyjinjin.ecommerce.common.exception.product.ProductNotFoundException;
import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductReader {

    private final ProductRepository productRepository;

    public Page<ProductEntity> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public ProductEntity read(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("상품을 찾을 수 없습니다.", id));
    }
}
