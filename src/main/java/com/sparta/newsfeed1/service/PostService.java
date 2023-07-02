package com.sparta.newsfeed1.service;

import com.sparta.newsfeed1.dto.PostRequestDto;
import com.sparta.newsfeed1.dto.PostResponseDto;
import com.sparta.newsfeed1.entity.Post;
import com.sparta.newsfeed1.entity.User;

public class PostService {

    public PostResponseDto createPost(PostRequestDto requestDto, User user){
        Post post  = new Post(requestDto);

    }


}
