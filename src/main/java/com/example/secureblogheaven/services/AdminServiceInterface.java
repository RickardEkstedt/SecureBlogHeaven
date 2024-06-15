package com.example.secureblogheaven.services;

import com.example.secureblogheaven.entities.User;

import java.util.List;
import java.util.Optional;

public interface AdminServiceInterface {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
}
