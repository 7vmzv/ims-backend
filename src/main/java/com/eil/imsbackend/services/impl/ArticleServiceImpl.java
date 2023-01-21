package com.eil.imsbackend.services.impl;

import com.eil.imsbackend.dto.ArticleDTO;
import com.eil.imsbackend.entities.Article;
import com.eil.imsbackend.exception.EntityNotFoundException;
import com.eil.imsbackend.exception.ErrorCodes;
import com.eil.imsbackend.exception.InvalidEntityException;
import com.eil.imsbackend.repository.ArticleRepository;
import com.eil.imsbackend.services.ArticleService;
import com.eil.imsbackend.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private ArticleValidator articleValidator;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleValidator articleValidator) {
        this.articleRepository = articleRepository;
        this.articleValidator = articleValidator;
    }

    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
        List<String> errors = articleValidator.validate(articleDTO);

        if(!errors.isEmpty()) {
            log.error("Article is not valid", articleDTO);
            throw new InvalidEntityException("Article is not valid", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return articleDTO.fromEntity(
                articleRepository.save(
                        articleDTO.toEntity(articleDTO)
                )
        );
    }

    @Override
    public ArticleDTO findById(Integer id) {
        if(id == null) {
            log.error("Article id id null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);
        ArticleDTO articleDTO = ArticleDTO.fromEntity(article.get());

        return Optional.of(articleDTO).orElseThrow(() ->
            new EntityNotFoundException("No Article with id = " + id + "in database", ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDTO findByArticleCode(String articleCode) {
        if(!StringUtils.hasLength(articleCode)) {
            log.error("Article code id null");
            return null;
        }

        Optional<Article> article = Optional.ofNullable(articleRepository.findByArticleCode(articleCode));
        ArticleDTO articleDTO = ArticleDTO.fromEntity(article.get());

        return Optional.of(articleDTO).orElseThrow(() ->
                new EntityNotFoundException("No Article with articleCode = " + articleCode + " in database", ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }


    @Override
    public List<ArticleDTO> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Article id id null");
        }

        articleRepository.deleteById(id);
    }


}
