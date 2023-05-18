package com.careerwatch.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/resumes")
public class ResumeController {
    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeDto> getResumeById( @PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(resumeService.getResumeById(resumeId));
    }

    public ResponseEntity<List<ResumeDto> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<ResumeDto> createResume(@PathVariable Long userId, @RequestBody ResumeDto resumeDto) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.CREATED).body(resumeService.createResume(userId, resumeDto));
    }

    @PutMapping("/{resumeId}")
    public ResponseEntity<ResumeDto> updateResume(@PathVariable Long resumeId, @ModelAttribute ResumeDto resumeDto) throws JsonProcessingException {
        return ResponseEntity.ok(resumeService.updateResume(userId, resumeId, resumeDto));
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long userId, @PathVariable Long resumeId) throws JsonProcessingException {
        userService.deleteResume(userId, resumeId);
        return ResponseEntity.noContent().build();
    }

};