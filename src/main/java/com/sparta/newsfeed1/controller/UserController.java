package com.sparta.newsfeed1.controller;

import com.sparta.newsfeed1.dto.ApiResponseDto;
import com.sparta.newsfeed1.dto.AuthRequestDto;
import com.sparta.newsfeed1.jwt.JwtUtil;
import com.sparta.newsfeed1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;


//회원가입
@RequestMapping("/api/user")
public class UserController {
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto> signUp(@Valid @RequestBody AuthRequestDto requestDto){
        try
        {
            userService.signup(requestDto);
        }catch (IllegalAccessException e){
            return ResponseEntity.badRequest().body(new ApiResponseDto("중복된 이름입니다.",HttpStatus.BAD_REQUEST.value()));
        }
        return ResponseEntity.status(200).body(new ApiResponseDto("SUCCESS_SIGN_UP", HttpStatus.CREATED.value()));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto> login(@RequestBody AuthRequestDto loginRequestDto, HttpServletResponse response){
        try
        {
            userService.login(loginRequestDto);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new ApiResponseDto("회원을 찾을 수 없다", HttpStatus.BAD_REQUEST.value()));
        }
        //Jwt 생성 및 쿠키에 저장 후 Response객체에 추가
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(loginRequestDto.getUername(),loginRequestDto.getRole()));

        return ResponseEntity.ok().body(new ApiResponseDto("SUCCESS_LOGIN"),HttpStatus.CREATED.value());
    }
}
