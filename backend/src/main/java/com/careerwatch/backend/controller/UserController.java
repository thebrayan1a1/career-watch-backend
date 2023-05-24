package com.careerwatch.backend.controller;

import com.careerwatch.backend.dto.user.UpdateUserDto;
import com.careerwatch.backend.dto.user.UserDto;
import com.careerwatch.backend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UpdateUserDto userDto) throws JsonProcessingException {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) throws JsonProcessingException {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}