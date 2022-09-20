package com.jinnyjinnyjinjin.ecommerce.domain.product.service;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.Category;
import com.jinnyjinnyjinjin.ecommerce.domain.category.service.CategoryReader;
import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPersistence {

    private final CategoryReader categoryReader;
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
}
