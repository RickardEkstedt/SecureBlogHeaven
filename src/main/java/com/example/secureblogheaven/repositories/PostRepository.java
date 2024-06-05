package com.example.secureblogheaven.repositories;

import com.example.secureblogheaven.enteties.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {}