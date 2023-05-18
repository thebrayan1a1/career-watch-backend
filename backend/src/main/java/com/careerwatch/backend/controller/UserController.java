package com.careerwatch.backend.controller;


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
@RequestMapping("/v1/users")
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

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @ModelAttribute UserDto userDto) throws JsonProcessingException {
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

    @GetMapping("/{userId}/resumes/{resumeId}")
    public ResponseEntity<ResumeDto> getResumeById(@PathVariable Long userId, @PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getResumeById(userId, resumeId));
    }

    @PostMapping("/{userId}/resumes")
    public ResponseEntity<ResumeDto> createResume(@PathVariable Long userId, @RequestBody ResumeDto resumeDto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createResume(userId, resumeDto));
    }

    @PutMapping("/{userId}/resumes/{resumeId}")
    public ResponseEntity<ResumeDto> updateResume(@PathVariable Long userId, @PathVariable Long resumeId, @ModelAttribute ResumeDto resumeDto) throws JsonProcessingException {
        return ResponseEntity.ok(userService.updateResume(userId, resumeId, resumeDto));
    }

    @DeleteMapping("/{userId}/resumes/{resumeId}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long userId, @PathVariable Long resumeId) throws JsonProcessingException {
        userService.deleteResume(userId, resumeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/resumes/{resumeId}/applications")
    public ResponseEntity<List<ApplicationDto>> getAllApplicationsByResumeId(@PathVariable Long userId, @PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getAllApplicationsByResumeId(userId, resumeId));
    }

    @GetMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getApplicationById(userId, resumeId, applicationId));
    }

    @PostMapping("/{userId}/resumes/{resumeId}/applications")
    public ResponseEntity<ApplicationDto> createApplication(@PathVariable Long userId, @PathVariable Long resumeId, @RequestBody ApplicationDto applicationDto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createApplication(userId, resumeId, applicationDto));
    }

    @PutMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId, @ModelAttribute ApplicationDto applicationDto) throws JsonProcessingException {
        return ResponseEntity.ok(userService.updateApplication(userId, resumeId, applicationId, applicationDto));
    }

    @DeleteMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId) throws JsonProcessingException {
        userService.deleteApplication(userId, resumeId, applicationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}/stages")
    public ResponseEntity<List<StageDto>> getAllStagesByApplicationId(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getAllStagesByApplicationId(userId, resumeId, applicationId));
    }

    @GetMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}/stages/{stageId}")
    public ResponseEntity<StageDto> getStageById(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId, @PathVariable Long stageId) throws JsonProcessingException {
        return ResponseEntity.ok(userService.getStageById(userId, resumeId, applicationId, stageId));
    }

    @PostMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}/stages")
    public ResponseEntity<StageDto> createStage(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId, @RequestBody StageDto stageDto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createStage(userId, resumeId, applicationId, stageDto));
    }

    @PutMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}/stages/{stageId}")
    public ResponseEntity<StageDto> updateStage(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId, @PathVariable Long stageId, @ModelAttribute StageDto stageDto) throws JsonProcessingException {
        return ResponseEntity.ok(userService.updateStage(userId, resumeId, applicationId, stageId, stageDto));
    }

    @DeleteMapping("/{userId}/resumes/{resumeId}/applications/{applicationId}/stages/{stageId}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long userId, @PathVariable Long resumeId, @PathVariable Long applicationId, @PathVariable Long stageId) throws JsonProcessingException {
        userService.deleteStage(userId, resumeId, applicationId, stageId);
        return ResponseEntity.noContent().build();
    }
    
}