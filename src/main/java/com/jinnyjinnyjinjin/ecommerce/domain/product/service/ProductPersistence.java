package com.jinnyjinnyjinjin.ecommerce.domain.product.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.service.CategoryReader;
import com.jinnyjinnyjinjin.ecommerce.domain.product.dto.Product;
import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductPersistence {

    private final CategoryReader categoryReader;
    private final ProductReader productReader;
    private final ProductWriter productWriter;

    public void save(String name,
                     String imageUrl,
                     double price,
                     String description,
                     Long categoryId) {

        Category category = categoryReader.read(categoryId);

        ProductEntity product =
                ProductEntity.create(
                        name,
                        imageUrl,
                        price,
                        description,
                        category);

        productWriter.write(product);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productReader.findAll(pageable)
                .map(Product::of);
    }

    @Transactional
    public void update(Long id, Product product) {

        ProductEntity productEntity = productReader.findById(id);
        Category category = categoryReader.read(product.getCategoryId());

        productEntity.update(
                productEntity.getName(),
                productEntity.getImageUrl(),
                productEntity.getPrice(),
                productEntity.getDescription(),
                category
        );
    }
}
