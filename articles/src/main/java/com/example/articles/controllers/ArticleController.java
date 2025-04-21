package com.example.articles.controllers;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.models.User;
import com.example.articles.service.ArticleService;
import com.example.articles.service.TagService;
import com.example.articles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final TagService tagService;
    private final ArticleService articleService;
    private final UserService userService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");

    @Autowired
    public ArticleController(TagService tagService, ArticleService articleService, UserService userService) {
        this.tagService = tagService;
        this.articleService = articleService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        model.addAttribute("article", article);
        model.addAttribute("formattedDate", article.getCreated_at().format(formatter));
        model.addAttribute("formattedUpdateDate", article.getUpdated_at().format(formatter));
        return "articles/details";
    }

    @GetMapping("/create")
    public String showCreateArticleForm(Model model) {
        List<Tag> tags = tagService.getAllTags();
        List<User> users = userService.getAllUsers();
        model.addAttribute("article", new Article());
        model.addAttribute("tags", tags);
        model.addAttribute("users", users);
        return "articles/create";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute Article article) {
        User currentUser = userService.getCurrentUser();
        article.setUser(currentUser);
        article.setSlug(articleService.generateSlug(article.getTitle()));
        articleService.save(article);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        List<Tag> tags = tagService.getAllTags();

        model.addAttribute("article", article);
        model.addAttribute("tags", tags);

        return "articles/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateArticle(@PathVariable Long id, @ModelAttribute Article article) {
        User currentUser = userService.getCurrentUser();
        Article existingArticle = articleService.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        if (!existingArticle.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("You cannot edit this article");
        }

        article.setId(id);
        article.setUser(currentUser);
        articleService.update(id, article);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/by-tag/{tagId}")
    public String getArticlesByTag(@PathVariable Long tagId, Model model) {
        Tag tag = new Tag();
        tag.setId(tagId);
        List<Article> articles = articleService.findArticlesByTag(tag);
        model.addAttribute("articles", articles);
        return "articles/list";
    }
}