package com.example.secureblogheaven.services;

import com.example.secureblogheaven.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostServiceInterface {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    Post createPost(Post post);
    Post updatePost(Long id, Post postDetails);
    void deletePost(Long id);
}
