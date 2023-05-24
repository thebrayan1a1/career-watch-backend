package com.careerwatch.backend.controller;

import com.careerwatch.backend.dto.resume.EducationDto;
import com.careerwatch.backend.dto.resume.UpdateEducationDto;
import com.careerwatch.backend.service.EducationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/educations")
public class EducationController {
    
    private final EducationService educationService;


    @PostMapping("/{resumeId}")
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto) throws JsonProcessingException {
        return ResponseEntity.ok(educationService.createEducation(educationDto));
    }
    @GetMapping("/{resumeId}")
    public ResponseEntity<List<EducationDto>> getAllEducations(@PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(educationService.getAllEducations(resumeId));
    }

    @GetMapping("/{educationId}")
    public ResponseEntity<EducationDto> getEducationById(@PathVariable Long educationId) throws JsonProcessingException  {
        return ResponseEntity.ok(educationService.getEducation(educationId));
    }

    @PutMapping("/{educationId}")
    public ResponseEntity<EducationDto> updateEducation(@PathVariable Long educationId, @RequestBody UpdateEducationDto educationDto) throws JsonProcessingException {
        return ResponseEntity.ok(educationService.updateEducation(educationId, educationDto));
    }

    @DeleteMapping("/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long educationId) throws JsonProcessingException {
        educationService.deleteEducation(educationId);
        return ResponseEntity.noContent().build();
    }
    
}
