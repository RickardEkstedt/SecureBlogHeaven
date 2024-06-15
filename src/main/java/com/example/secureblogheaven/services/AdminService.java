package com.example.secureblogheaven.services;

import com.example.secureblogheaven.entities.User;
import com.example.secureblogheaven.execptions.ResourceNotFoundException;
import com.example.secureblogheaven.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements AdminServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return userOptional;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}

