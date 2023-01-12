package com.eil.imsbackend.validatorTests;


import com.eil.imsbackend.dto.CategoryDTO;
import com.eil.imsbackend.dto.CompanyDTO;
import com.eil.imsbackend.validator.CategoryValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryValidatorTest {
    private final String message = "Please entre a valid category code";

    private CategoryValidator categoryValidator = new CategoryValidator();


    @Test
    public void should_return_list_with_message_when_given_null(){
        //act
        List<String> actual = categoryValidator.validate(null);

        List<String> expected = new ArrayList<>();
        expected.add(message);

        //assert
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void should_return_list_with_message_when_given_CategoryDTO_with_empty_string_code(){
        //arrange
        CategoryDTO categoryDTO = mock(CategoryDTO.class);
        when(categoryDTO.getCategoryCode()).thenReturn("");

        List<String> expected = new ArrayList<>();
        expected.add(message);


        //act
        List<String> actual = categoryValidator.validate(categoryDTO);

        //assert
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void should_return_list_with_message_when_given_CategoryDTO_with_valid_code(){
        //arrange
        CategoryDTO categoryDTO = mock(CategoryDTO.class);
        when(categoryDTO.getCategoryCode()).thenReturn("a_string_code_here");

        //act
        List<String> actual = categoryValidator.validate(categoryDTO);

        //assert
        Assertions.assertIterableEquals(new ArrayList<>(), actual);
    }
}
