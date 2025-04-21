package com.example.articles.service;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;

import java.util.List;
import java.util.Optional;


public interface IArticleService {
    List<Article> findAll();
    Optional<Article> findById(Long id);
    List<Article> findArticlesByTag(Tag tag);
    Article save(Article article);
    Article update(Long id,Article article);
    void deleteById(Long id);
}