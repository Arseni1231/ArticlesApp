package com.example.articles.config;

import com.example.articles.models.Article;
import com.example.articles.models.Roles;
import com.example.articles.models.Tag;
import com.example.articles.models.User;
import com.example.articles.repositories.ArticleRepository;
import com.example.articles.repositories.TagRepository;
import com.example.articles.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void run(String... args) throws Exception {
        seedUsers();
        seedTags();
        seedArticles();
        User admin =new User();
        admin.setCreated_at(LocalDateTime.now());
        admin.setEmail("admin@gmail.com");
        admin.setImage_url("https://example.com/image.png");
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        admin.setBio("admin bio");
        admin.setRole(Roles.ROLE_ADMIN);
        userRepository.save(admin);

        User user =new User();
        user.setCreated_at(LocalDateTime.now());
        user.setEmail(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setBio(faker.lorem().paragraph());
        user.setImage_url(faker.internet().url());
        user.setRole(Roles.ROLE_USER);
        userRepository.save(user);
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
        List<String> tagNames = List.of("C++", "Java", "Python", "Ruby", "JavaScript");
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