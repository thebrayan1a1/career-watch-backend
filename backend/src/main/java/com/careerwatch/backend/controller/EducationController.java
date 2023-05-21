package com.careerwatch.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/educations")
public class EducationController {
    
    private final educationService educationService;
    

    @GetMapping
    public ResponseEntity<List<educationDto>> getAllEducations() throws JsonProcessingException {
        return ResponseEntity.ok(educationService.getAllEducations());
    }

    @GetMapping("/{educationId}")
    public ResponseEntity<educationDto> getEducationById(@PathVariable Long educationId) throws JsonProcessingException  {
        return ResponseEntity.ok(educationService.getEducationById(educationId));
    }

    @PutMapping("/{educationId}")
    public ResponseEntity<educationDto> updateEducation(@PathVariable Long educationId, @ModelAttribute educationDto educationDto) throws JsonProcessingException {
        return ResponseEntity.ok(educationService.updateEducation(educationId, educationDto));
    }

    @DeleteMapping("/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) throws JsonProcessingException {
        educationService.deleteEducation(educationId);
        return ResponseEntity.noContent().build();
    }
    
}
