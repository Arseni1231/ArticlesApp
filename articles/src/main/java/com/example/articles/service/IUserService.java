package com.example.articles.service;

import com.example.articles.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> findByUsername(String username);
    User getCurrentUser();

    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
