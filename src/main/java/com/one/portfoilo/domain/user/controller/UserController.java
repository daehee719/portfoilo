package com.one.portfoilo.domain.user.controller;

import com.one.portfoilo.domain.user.dto.UserSignUpDto;
import com.one.portfoilo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        return ResponseEntity.ok(userService.signUp(userSignUpDto));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() throws Exception {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.getUser(id));
    }
}