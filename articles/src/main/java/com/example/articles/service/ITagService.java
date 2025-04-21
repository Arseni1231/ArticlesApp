package com.example.articles.service;

import com.example.articles.models.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> getAllTags();
    Tag addNewTag(Tag tag);
    void removeTag(Long id);
}
