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
@RequestMapping("/api/v1/experiences")
public class ExperienceController {
    
    private final ExperienceService experienceService;
    

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getAllExperiences() throws JsonProcessingException {
        return ResponseEntity.ok(experienceService.getAllExperiences());
    }

    @GetMapping("/{experienceId}")
    public ResponseEntity<ExperienceDto> getExperienceById(@PathVariable Long experienceId) throws JsonProcessingException  {
        return ResponseEntity.ok(experienceService.getExperienceById(experienceId));
    }

    @PutMapping("/{experienceId}")
    public ResponseEntity<ExperienceDto> updateExperience(@PathVariable Long experienceId, @ModelAttribute ExperienceDto experienceDto) throws JsonProcessingException {
        return ResponseEntity.ok(experienceService.updateExperience(experienceId, experienceDto));
    }

    @DeleteMapping("/{experienceId}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long experienceId) throws JsonProcessingException {
        experienceService.deleteExperience(experienceId);
        return ResponseEntity.noContent().build();
    }
    
}
