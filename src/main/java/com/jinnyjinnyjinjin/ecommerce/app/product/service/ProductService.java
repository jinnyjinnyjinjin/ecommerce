package com.jinnyjinnyjinjin.ecommerce.app.product.service;

import com.jinnyjinnyjinjin.ecommerce.app.product.api.response.ProductResponse;
import com.jinnyjinnyjinjin.ecommerce.app.product.dto.ProductDto;
import com.jinnyjinnyjinjin.ecommerce.domain.product.dto.Product;
import com.jinnyjinnyjinjin.ecommerce.domain.product.service.ProductPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ProductResponse> getAll(Pageable pageable) {
        Page<ProductDto> products = productPersistence.findAll(pageable)
                .map(ProductDto::of);
        return products.map(ProductResponse::of);
    }

    public void update(Long id, ProductDto productDto) {

        Product product = Product.of(
                productDto.getName(),
                productDto.getImageUrl(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getCategoryId()
        );
        productPersistence.update(id, product);
    }
}
