package com.sparta.newsfeed1.controller;


import com.sparta.newsfeed1.dto.ApiResponseDto;
import com.sparta.newsfeed1.dto.PostRequestDto;
import com.sparta.newsfeed1.dto.PostResponseDto;
import com.sparta.newsfeed1.security.UserDetailsImpl;
import com.sparta.newsfeed1.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;


    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto){
        PostRequestDto result = postService.creatPost(requestDto, userDetails.getUer());


        return ResponseEntity.status(200).body(result);
    }


    @GetMapping("/posts")
    public ResponseEntity<PostListReponseDto> getPoests(){
        PostListResponseDto result = postService.getPosts();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/posts/{id]")
    public ResponseEntity<PostResponseDto> getPostById(@PathVariable Long id){
        postResponseDto result = postService.getPostById(id);

        return ResponseEntity.ok().body(result);
    }
    @PutMapping("/posts/{id}")
    public ResponseEntity<ApiResponseDto> updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable PostRequestDto requestDto){
        try{
            postRsponseDto reuslt = postService.updatePost(id, requestDto,userDetails.getUser());
        }
    }
}
