package com.example.articles.controllers;

import com.example.articles.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.service.ITagService;
import com.example.articles.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tags")
public class TagController {

    private final ITagService tagService;
    private final IArticleService articleService;

    @Autowired
    public TagController(ITagService tagService, IArticleService articleService) {
        this.tagService = tagService;
        this.articleService = articleService;
    }

    // Показать все теги
    @GetMapping
    public String listTags(Model model) {
        model.addAttribute("tags", tagService.getAllTags());
        return "tags/list"; // -> templates/tags/list.html
    }

    // Форма создания
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "tags/create"; // -> templates/tags/create.html
    }

    // Обработка формы создания
    @PostMapping("/create")
    public String createTag(@ModelAttribute Tag tag) {
        tagService.addNewTag(tag);
        return "redirect:/tags";
    }

    // Удаление тега
    @GetMapping("/{id}/delete")
    public String deleteTag(@PathVariable Long id) {
        tagService.removeTag(id);
        return "redirect:/tags";
    }

    // Показать статьи по тегу
    @GetMapping("/{id}/articles")
    public String showArticlesByTag(@PathVariable Long id, Model model) {
        Tag tag = tagService.getAllTags().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Тег не найден"));
        List<Article> articles = articleService.findArticlesByTag(tag);
        model.addAttribute("tag", tag);
        model.addAttribute("articles", articles);
        return "tags/articles"; // -> templates/tags/articles.html
    }
}

