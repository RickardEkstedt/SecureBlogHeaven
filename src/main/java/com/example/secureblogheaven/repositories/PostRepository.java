package com.example.secureblogheaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.secureblogheaven.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
