package com.jinnyjinnyjinjin.ecommerce.domain.product.service;

import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import com.jinnyjinnyjinjin.ecommerce.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class ProductWriter {

    private final ProductRepository productRepository;

    public void write(ProductEntity product) {
        productRepository.save(product);
    }
}
