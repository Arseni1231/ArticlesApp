package com.example.articles.controllers;

import com.example.articles.models.User;
import com.example.articles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Просмотр списка всех пользователей (с проверкой админских прав)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }

    // Просмотр профиля пользователя
    @GetMapping("/{id}")
    public String viewUserProfile(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);
        model.addAttribute("joinDate", user.getCreated_at().format(dateFormatter));
        return "users/profile";
    }

    // Форма регистрации нового пользователя
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    // Обработка регистрации
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users/login";
    }

    // Форма редактирования профиля (только для админа или владельца)
    @GetMapping("/{id}/edit")
    @PreAuthorize("#id == principal.id or hasRole('ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        model.addAttribute("user", user);
        return "users/edit-profile";
    }

    // Обновление профиля
    @PostMapping("/{id}/edit")
    @PreAuthorize("#id == principal.id or hasRole('ADMIN')")
    public String updateProfile(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users/" + id;
    }

    // Удаление пользователя (только для админа)
    @PostMapping("/{id}/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
