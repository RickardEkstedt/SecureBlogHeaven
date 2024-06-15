package com.example.secureblogheaven.controllers;

import com.example.secureblogheaven.entities.Post;
import com.example.secureblogheaven.execptions.ResourceNotFoundException;
import com.example.secureblogheaven.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public  ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        try {
            Post post = postService.getPostById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
            return ResponseEntity.ok(post);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PostMapping("/newpost")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/updatepost/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        try {
            Post updatedPost = postService.updatePost(id, postDetails);
            return ResponseEntity.ok(updatedPost);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/deletepost/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        try {
            postService.deletePost(id);
            return ResponseEntity.ok("Post deleted successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
