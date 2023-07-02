package com.sparta.newsfeed1.security;

import com.sparta.newsfeed1.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private final User user;
    public UserDetailsImpl(User user){
        this.user  = user;
    }
    private User getUser(){
        return this.user;
    }
    @Override
    public String getPassword(){
        return user.getPassword();
    }
    @Override
    public String getUsername(){
        return user.getUsername();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
