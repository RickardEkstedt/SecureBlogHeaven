package com.example.secureblogheaven.controllers;

import com.example.secureblogheaven.entities.User;
import com.example.secureblogheaven.execptions.ResourceNotFoundException;
import com.example.secureblogheaven.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('client_ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = adminService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('client_ADMIN')")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = adminService.getUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/newuser")
    @PreAuthorize("hasRole('client_ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = adminService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
