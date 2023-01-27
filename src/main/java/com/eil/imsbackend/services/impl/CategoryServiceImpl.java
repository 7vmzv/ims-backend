package com.eil.imsbackend.services.impl;

import com.eil.imsbackend.dto.CategoryDTO;
import com.eil.imsbackend.entities.Category;
import com.eil.imsbackend.exception.EntityNotFoundException;
import com.eil.imsbackend.exception.ErrorCodes;
import com.eil.imsbackend.exception.InvalidEntityException;
import com.eil.imsbackend.repository.CategoryRepository;
import com.eil.imsbackend.services.CategoryService;
import com.eil.imsbackend.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryValidator categoryValidator;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryValidator categoryValidator) {
        this.categoryRepository = categoryRepository;
        this.categoryValidator = categoryValidator;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        List<String> errors = categoryValidator.validate(categoryDTO);

        if(!errors.isEmpty()) {
            log.error("Category is not valid", categoryDTO);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }

        return categoryDTO.fromEntity(
                categoryRepository.save(
                        categoryDTO.toEntity(categoryDTO)
                )
        );
    }

    @Override
    public CategoryDTO findById(Integer id) {
        if(id == null) {
            log.error("Article id id null");
            return null;
        }

        Optional<Category> category = categoryRepository.findById(id);
        CategoryDTO categoryDTO = CategoryDTO.fromEntity(category.get());

        return Optional.of(categoryDTO).orElseThrow(() ->
                new EntityNotFoundException("No Category with id = " + id + "in database", ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDTO findByCategoryCode(String categoryCode) {
        if(!StringUtils.hasLength(categoryCode)) {
            log.error("Category code id null");
            return null;
        }

        Optional<Category> category = Optional.ofNullable(categoryRepository.findByCategoryCode(categoryCode));
        CategoryDTO categoryDTO = CategoryDTO.fromEntity(category.get());

        return Optional.of(categoryDTO).orElseThrow(() ->
                new EntityNotFoundException("No Category with categoryCode = " + categoryCode + " in database", ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Category id id null");
        }

        categoryRepository.deleteById(id);
    }
}
