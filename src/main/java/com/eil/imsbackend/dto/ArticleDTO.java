package com.eil.imsbackend.dto;

import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.entities.Category;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleDTO {

    private String articleCode;
    private String description;

    private BigDecimal unitPriceHT;
    private BigDecimal tva;
    private BigDecimal unitPriceTTC;

    private String photo;

    private CategoryDTO category;

    public static ArticleDTO fromEntity(Article article) {
        if (article == null) {
            return null;
        }

        return ArticleDTO.builder()
                .articleCode(article.getArticleCode())
                .description(article.getDescription())
                .photo(article.getPhoto())
                .tva(article.getTva())
                .unitPriceHT(article.getUnitPriceHT())
                .unitPriceTTC(article.getUnitPriceTTC())
                .build();
    }

    public static Article toEntity(ArticleDTO articleDTO) {
        if(articleDTO == null) {
            return null;
        }

        Article article = new Article();
        article.setArticleCode(articleDTO.getArticleCode());
        article.setDescription(articleDTO.getDescription());
        article.setPhoto(articleDTO.getPhoto());
        article.setTva(articleDTO.getTva());
        article.setUnitPriceHT(articleDTO.getUnitPriceHT());
        article.setUnitPriceTTC(articleDTO.getUnitPriceTTC());

        return article;
    }
}
