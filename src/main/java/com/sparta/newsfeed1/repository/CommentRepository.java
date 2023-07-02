package com.sparta.newsfeed1.repository;

import com.sparta.newsfeed1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
