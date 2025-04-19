package com.practice.posts.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    int id;
    String login;
    LocalDateTime createdAt;
}
