package com.example.secureblogheaven.services;

import com.example.secureblogheaven.entities.Post;
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
    public Optional<Post> updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.setContent(postDetails.getContent());
            return postRepository.save(post);
        });
    }

    @Override
    public boolean deletePost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            postRepository.delete(post.get());
            return true;
        }
        return false;
    }
}

package com.example.secureblogheaven.services;

        import com.example.secureblogheaven.entities.Post;

        import java.util.List;
        import java.util.Optional;

public interface PostServiceInterface {
    List<Post> getAllPosts();
    Optional<Post> getPostById(Long id);
    Post createPost(Post post);
    Optional<Post> updatePost(Long id, Post postDetails);
    boolean deletePost(Long id);
}
