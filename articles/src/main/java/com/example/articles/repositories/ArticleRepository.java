package com.example.articles.repositories;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitleContainingIgnoreCase(String title);
    List<Article> findByTagsContaining(Tag tag);

}
