package com.example.articles.config;

import com.example.articles.models.Article;
import com.example.articles.models.Tag;
import com.example.articles.models.User;
import com.example.articles.repositories.ArticleRepository;
import com.example.articles.repositories.TagRepository;
import com.example.articles.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import javax.lang.model.type.ArrayType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class InsertData implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final TagRepository tagRepository;
    private final Faker faker = new Faker();
    private final Random random = new Random();

    public InsertData(UserRepository userRepository, ArticleRepository articleRepository, TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        seedUsers();
        seedTags();
        seedArticles();
    }

    private void seedUsers() {
        for (int i = 0; i < 5; i++) {
            User user = new User();
            System.out.println(faker.internet().emailAddress());
            user.setEmail(faker.internet().emailAddress());
            user.setUsername(faker.name().username());
            user.setImage_url(faker.internet().avatar());
            user.setPassword("password123");
            user.setBio(faker.lorem().sentence());
            userRepository.save(user);
        }
    }

    private void seedTags() {
        List<String> tagNames = List.of("Technology", "Science", "Programming", "AI", "Writting");
        for (String tagName : tagNames) {
            Tag tag = new Tag();
            tag.setName(tagName);
            tagRepository.save(tag);
        }
    }

    private void seedArticles() {
        List<User> users = userRepository.findAll();
        List<Tag> tags = tagRepository.findAll();

        for (int i = 0; i < 10; i++) {
            Article article = new Article();
            article.setUser(users.get(random.nextInt(users.size())));
            article.setTitle(faker.book().title());
            article.setContent(faker.lorem().sentence());
            String slug = faker.lorem().characters(10, 20, true);
            article.setSlug(slug);

            articleRepository.save(article);
        }
    }
}