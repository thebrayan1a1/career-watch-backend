package com.careerwatch.backend.controller;


import com.careerwatch.backend.dto.user.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    
    private final UserService userService;
    

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() throws JsonProcessingException {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) throws JsonProcessingException  {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) throws JsonProcessingException {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws JsonProcessingException {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/resumes")
    public ResponseEntity<List<ResumeDto>> getAllResumesByUserId(@PathVariable Long userId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getAllResumesByUserId(userId));
    }
}