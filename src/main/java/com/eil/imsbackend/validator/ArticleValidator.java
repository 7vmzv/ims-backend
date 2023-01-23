package com.eil.imsbackend.validator;

import com.eil.imsbackend.dto.ArticleDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleValidator {

    public List<String> validate(ArticleDTO articleDTO) {
        List<String> errors = new ArrayList<>();

        if(articleDTO == null) {
            throw new NullPointerException("given ref is null");
        } else {

            if(!StringUtils.hasLength(articleDTO.getArticleCode())){
                errors.add(String.format("%s entered is not valid", "article code"));
            }

            if(!StringUtils.hasLength(articleDTO.getDescription()) || !articleDTO.getDescription().matches("[A-Za-z\\d ]*")){
                errors.add(String.format("%s entered is not valid", "description"));
            }

            if(articleDTO.getTva() == null || (articleDTO.getTva().compareTo(new BigDecimal(50)) > 0 || articleDTO.getTva().compareTo(new BigDecimal(0)) < 0)){
                errors.add(String.format("%s entered is not valid", "tva"));
            }

            if(articleDTO.getUnitPriceHT() == null || (articleDTO.getUnitPriceHT().compareTo(new BigDecimal(0)) < 0)){
                errors.add(String.format("%s entered is not valid", "UnitPriceHT"));
            }

            if(articleDTO.getUnitPriceTTC() == null || (articleDTO.getUnitPriceTTC().compareTo(new BigDecimal(0)) < 0)){
                errors.add(String.format("%s entered is not valid", "UnitPriceTTC"));
            }
        }

        return errors;
    }
}
