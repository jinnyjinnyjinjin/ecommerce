package com.jinnyjinnyjinjin.ecommerce.app.product.service;

import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import com.jinnyjinnyjinjin.ecommerce.domain.product.service.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductPersistence productPersistence;

    public void add(ProductDto productDto) {
        productPersistence.save(
                productDto.getName(),
                productDto.getImageUrl(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getCategoryId()
        );
    }
}
