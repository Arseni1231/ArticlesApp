package com.example.articles.service;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.repositories.ArticleRepository;
import com.example.articles.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITagService {
    private final TagRepository tagRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public TagService(TagRepository tagRepository, ArticleRepository articleRepository) {
        this.tagRepository = tagRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag addNewTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void removeTag(Long id) {
        Tag tag = getTagByIdOrThrow(id);
        untagArticles(tag);
        tagRepository.delete(tag);
    }

    private Tag getTagByIdOrThrow(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    private void untagArticles(Tag tag) {
        List<Article> taggedArticles = articleRepository.findByTagsContaining(tag);
        taggedArticles.forEach(article -> {
            article.getTags().remove(tag);
            articleRepository.save(article);
        });
    }
}
