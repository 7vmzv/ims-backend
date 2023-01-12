package com.eil.imsbackend.validator;

import com.eil.imsbackend.dto.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    private static final String message = "Please entre a valid category code";

    public List<String> validate(CategoryDTO categoryDTO){
        List<String> errors = new ArrayList<>();

        if(categoryDTO == null || !StringUtils.hasLength(categoryDTO.getCategoryCode())) {
            errors.add(message);
        }
        return errors;
    }
}