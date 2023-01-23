package com.eil.imsbackend.controllers;

import com.eil.imsbackend.dto.ArticleDTO;
import com.eil.imsbackend.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eil.imsbackend.utils.Constants.APP_ROOT;

@RestController
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(value = APP_ROOT + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDTO save(@RequestBody ArticleDTO articleDTO){
        return articleService.save(articleDTO);
    }

    @GetMapping(value = APP_ROOT + "/article/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDTO findById(@PathVariable Integer articleId) {
        return articleService.findById(articleId);
    }

    @GetMapping(value = APP_ROOT + "/article/{articleCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDTO findByArticleCode(@PathVariable String articleCode) {
        return articleService.findByArticleCode(articleCode);
    }

    @GetMapping(value = APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    @DeleteMapping(value = APP_ROOT + "/article/delete/{articleId}")
    public void delete(@PathVariable Integer articleId){
        articleService.delete(articleId);
    }
}
