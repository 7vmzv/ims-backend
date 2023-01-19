package com.eil.imsbackend.repository;

import com.eil.imsbackend.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Integer, Article> {
}
