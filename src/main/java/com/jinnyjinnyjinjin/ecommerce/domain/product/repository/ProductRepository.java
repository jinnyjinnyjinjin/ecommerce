package com.jinnyjinnyjinjin.ecommerce.domain.product.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
