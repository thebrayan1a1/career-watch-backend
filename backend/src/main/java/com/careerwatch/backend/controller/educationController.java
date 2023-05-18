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
@RequestMapping("/api/v1/educations")
public class educationController {
    
    private final educationService educationService;
    

    @GetMapping
    public ResponseEntity<List<educationDto>> getAlleducations() throws JsonProcessingException {
        return ResponseEntity.ok(educationService.getAlleducations());
    }

    @GetMapping("/{educationId}")
    public ResponseEntity<educationDto> geteducationById(@PathVariable Long educationId) throws JsonProcessingException  {
        return ResponseEntity.ok(educationService.geteducationById(educationId));
    }

    @PutMapping("/{educationId}")
    public ResponseEntity<educationDto> updateeducation(@PathVariable Long educationId, @ModelAttribute educationDto educationDto) throws JsonProcessingException {
        return ResponseEntity.ok(educationService.updateeducation(educationId, educationDto));
    }

    @DeleteMapping("/{educationId}")
    public ResponseEntity<Void> deleteeducation(@PathVariable Long educationId) throws JsonProcessingException {
        educationService.deleteeducation(educationId);
        return ResponseEntity.noContent().build();
    }
    
}
