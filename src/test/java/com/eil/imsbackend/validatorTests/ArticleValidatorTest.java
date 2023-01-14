package com.eil.imsbackend.validatorTests;

import com.eil.imsbackend.dto.ArticleDTO;
import com.eil.imsbackend.dto.UserDTO;
import com.eil.imsbackend.entities.Address;
import com.eil.imsbackend.validator.ArticleValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ArticleValidatorTest {
    ArticleValidator articleValidator = new ArticleValidator();

    @Test
    public void should_throw_when_given_null_ref() {

        Assertions.assertThrows(NullPointerException.class, () -> {
           articleValidator.validate(null);
        });
    }

    @Test
    public void should_return_list_with_all_errors_messages_when_given_non_valid_entries() {
        //Arrange
        ArticleDTO articleDTO = new ArticleDTO();

        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s entered is not valid", "UnitPriceTTC"));
        expected.add(String.format("%s entered is not valid", "UnitPriceHT"));
        expected.add(String.format("%s entered is not valid", "tva"));
        expected.add(String.format("%s entered is not valid", "description"));
        expected.add(String.format("%s entered is not valid", "article code"));

        expected.forEach((s) -> {
            System.out.println(s);
        });
        System.out.println("-----------------------");
        //Act
        List<String> actual = articleValidator.validate(articleDTO);

        actual.forEach((s) -> {
            System.out.println(s);
        });

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void should_return_list_with_non_valid_lastname_message_when_given_just_non_valid_tva() {
        //Arrange
        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setArticleCode("code");
        articleDTO.setDescription("here is the description");
        articleDTO.setUnitPriceHT(new BigDecimal(120));
        articleDTO.setUnitPriceTTC(new BigDecimal(201));


        List<String> expected = new ArrayList<>();
        expected.add(String.format("%s entered is not valid", "tva"));

        //act
        List<String> actual = articleValidator.validate(articleDTO);

        //assert
        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray()));
    }
}
