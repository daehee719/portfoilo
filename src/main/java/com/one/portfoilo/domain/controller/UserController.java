package com.one.portfoilo.domain.controller;

import com.one.portfoilo.domain.dto.UserSignUpDto;
import com.one.portfoilo.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpDto userSignUpDto) throws Exception {
        userService.signUp(userSignUpDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/jwt-test")
    public ResponseEntity<?> jwtTest() {
        return ResponseEntity.ok("jwtTest 요청 성공");
    }
}