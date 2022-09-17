package com.jinnyjinnyjinjin.ecommerce.category.domain.repository;

import com.jinnyjinnyjinjin.ecommerce.category.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
