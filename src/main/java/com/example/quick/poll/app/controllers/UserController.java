package com.example.quick.poll.app.controllers;

import com.example.quick.poll.app.models.User;
import com.example.quick.poll.app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        log.info("received request to create user: {}", user);
        User userObj = userRepository.save(user);
        return ResponseEntity.ok("Created user successfully with id: " + userObj.getId());
    }
}
