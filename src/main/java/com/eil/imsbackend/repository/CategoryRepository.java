package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategoryCode(String categoryCode);
}
