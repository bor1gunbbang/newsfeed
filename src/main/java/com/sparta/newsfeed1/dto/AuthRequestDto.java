package com.sparta.newsfeed1.dto;


import com.sparta.newsfeed1.entity.UserRoleEnum;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.PatchExchange;

@Getter
@Setter
public class AuthRequestDto {
    @Pattern(regexp = "^[a-z0-9]{4,10}$",message = "최소 4자이상, 10자이하이며 알페벳 소문자와 숫자로 구성되어야한다.")
    private String username;
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()_+{}:\"<>?,.\\\\/]{8,15}$",message = "최소 8자이상, 15자이하이며 알페벳 대소문자와 숫자, 특수문자로 구성되어야한다.")
    private String password;


    private UserRoleEnum role;//회원 권환 확인
}
