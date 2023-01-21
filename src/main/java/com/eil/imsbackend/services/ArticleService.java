package com.eil.imsbackend.services;

import com.eil.imsbackend.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO save(ArticleDTO articleDTO);

    ArticleDTO findById(Integer id);

    ArticleDTO findByArticleCode(String articleCode);

    List<ArticleDTO> findAll();
}
