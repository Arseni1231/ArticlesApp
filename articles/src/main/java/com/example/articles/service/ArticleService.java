package com.example.articles.service;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> findArticlesByTag(Tag tag) {
        return articleRepository.findByTagsContaining(tag);
    }

    @Override
    @Transactional
    public Article save(Article article) {
        article.setSlug(generateSlug(article.getTitle()));
        article.setCreated_at(LocalDateTime.now());
        article.setUpdated_at(LocalDateTime.now());
        return articleRepository.save(article);
    }

    @Override
    @Transactional
    public Article update(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.setTitle(updatedArticle.getTitle());
                    existingArticle.setContent(updatedArticle.getContent());
                    existingArticle.setDescription(updatedArticle.getDescription());
                    existingArticle.setSlug(generateSlug(updatedArticle.getTitle()));
                    existingArticle.setTags(updatedArticle.getTags());
                    existingArticle.setUpdated_at(LocalDateTime.now());
                    return articleRepository.save(existingArticle);
                })
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    private String generateSlug(String title) {
        return title.toLowerCase()
                .replaceAll("[^a-z0-9 ]", "")
                .replaceAll("\\s+", "-");
    }
}