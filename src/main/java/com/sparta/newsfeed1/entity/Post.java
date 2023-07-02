package com.sparta.newsfeed1.entity;

import com.sparta.newsfeed1.dto.PostRequestDto;
import jakarta.persistence.*;

import java.util.List;

public class Post extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> coments;

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setContent(String content){
        this.content= content;
    }
    public void setUser(User user){
        this.user = user;

    }


}
