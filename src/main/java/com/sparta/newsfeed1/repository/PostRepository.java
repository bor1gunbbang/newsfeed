package com.sparta.newsfeed1.repository;

import com.sparta.newsfeed1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
