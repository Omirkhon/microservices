package com.practice.posts.dto;

import com.practice.posts.model.Post;
import lombok.Builder;

@Builder
public record PostDto(Integer id, String description, UserDto userDto) {
    public static PostDto of(Post post, UserDto userDto) {
        return builder()
                .id(post.getId())
                .description(post.getDescription())
                .userDto(userDto)
                .build();
    }
}
