package com.bugsense.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugsense.model.User;
import com.bugsense.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
public ResponseEntity<String> register(@RequestBody User user) {

    user.setRole(com.bugsense.model.enums.Role.USER);

    boolean success = userService.register(user);

    if (success) {
        return ResponseEntity.ok("User registered successfully!");
    }

    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Registration failed.");
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User user) {

    User loggedInUser = userService.login(user.getEmail(), user.getPassword());

    if (loggedInUser != null) {
        return ResponseEntity.ok(loggedInUser);
    }

    return ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .body("Invalid email or password.");
}
}