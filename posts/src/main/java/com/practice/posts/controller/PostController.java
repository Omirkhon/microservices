package com.practice.posts.controller;

import com.practice.posts.client.UserClient;
import com.practice.posts.dto.PostDto;
import com.practice.posts.dto.UserDto;
import com.practice.posts.model.Post;
import com.practice.posts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final UserClient userClient;
    private final PostRepository postRepository;

    @PostMapping
    public PostDto create(@RequestBody Post post, @RequestHeader("X-Authorized-User") int userId) {
        UserDto userDto = userClient.findById(userId);
        post.setAuthorId(userId);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        return PostDto.of(post, userDto);
    }

    @GetMapping("{postId}")
    public Post findById(@PathVariable int postId) {
        return postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler
    public ResponseEntity<?> handleHttpRequest(HttpClientErrorException ex) {
        return new ResponseEntity<>(
                ex.getResponseBodyAsString(),
                ex.getResponseHeaders(),
                ex.getStatusCode()
        );
    }
}
