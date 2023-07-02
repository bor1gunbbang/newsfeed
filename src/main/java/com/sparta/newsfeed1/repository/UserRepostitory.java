package com.sparta.newsfeed1.repository;

import com.sparta.newsfeed1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostitory extends JpaRepository<User,Long> {
}
