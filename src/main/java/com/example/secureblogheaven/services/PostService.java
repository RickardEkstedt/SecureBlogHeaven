package com.example.secureblogheaven.services;

import com.example.secureblogheaven.entities.Post;
import com.example.secureblogheaven.execptions.ResourceNotFoundException;
import com.example.secureblogheaven.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostServiceInterface {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }


    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.setContent(postDetails.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }

    @Override
    public void deletePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.delete(post.get());
        } else {
            throw new ResourceNotFoundException("Post", "id", id);
        }
    }
}
