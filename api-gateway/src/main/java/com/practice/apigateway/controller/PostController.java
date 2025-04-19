package com.practice.apigateway.controller;

import com.practice.apigateway.client.PostClient;
import com.practice.posts.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostClient postClient;

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        return postClient.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestHeader("X-Authorized-User") int userId, @RequestBody Post post) {
        return postClient.create(post, userId);
    }
}
