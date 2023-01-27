package com.eil.imsbackend.services;

import com.eil.imsbackend.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);

    CategoryDTO findById(Integer id);

    CategoryDTO findByCategoryCode(String categoryCode);

    List<CategoryDTO> findAll();

    void delete(Integer id);
}
