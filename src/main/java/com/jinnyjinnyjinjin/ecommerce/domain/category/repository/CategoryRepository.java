package com.jinnyjinnyjinjin.ecommerce.domain.category.repository;

import com.jinnyjinnyjinjin.ecommerce.domain.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
