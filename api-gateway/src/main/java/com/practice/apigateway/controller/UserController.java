package com.practice.apigateway.controller;

import com.practice.apigateway.client.UserClient;
import com.practice.users.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserClient userClient;

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        return userClient.findById(id);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody User user) {
        return userClient.create(user);
    }
}
