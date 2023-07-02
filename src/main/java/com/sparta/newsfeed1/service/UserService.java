package com.sparta.newsfeed1.service;

import com.sparta.newsfeed1.dto.AuthRequestDto;
import com.sparta.newsfeed1.entity.User;
import com.sparta.newsfeed1.entity.UserRoleEnum;
import com.sparta.newsfeed1.repository.UserRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepostitory userRepostitory;
    public void signup(AuthRequestDto requestDto) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());
        UserRoleEnum role = requestDto.getRole();

        if (userRepostitory.findByUsername(username).isPresent()){
            throw new IllegalArgumentException("이미 존재하느 회원입니다.");
        }
        User user = new User(username,password,role );
        userRepostitory.save(user);
    }
}
