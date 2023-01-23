package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Integer id;

    private String categoryCode;
    private String description;
    @JsonIgnore
    private List<ArticleDTO> articles;

    //Category -> CategoryDTO
    public CategoryDTO fromEntity(Category category){
        if(category == null) {
            //Throw an exception
            return null;
        }
        return CategoryDTO.builder()
                .id(category.getId())
                .categoryCode(category.getCategoryCode())
                .description(category.getDescription()).build();
    }

    //CategoryDTO -> Category
    public Category toEntity(CategoryDTO categoryDTO) {
        if(categoryDTO == null) {
            //Throw an exception
            return null;
        }
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryCode(categoryDTO.getCategoryCode());
        category.setDescription(categoryDTO.getDescription());

        return category;
    }
}
