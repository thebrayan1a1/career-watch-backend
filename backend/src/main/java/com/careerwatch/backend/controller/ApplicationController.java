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
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    private final ApplicationService applicationService;


    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() throws JsonProcessingException {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long applicationId) throws JsonProcessingException  {
        return ResponseEntity.ok(applicationService.getApplicationById(applicationId));
    }

    @PutMapping("/{applicationId}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long applicationId, @ModelAttribute ApplicationDto applicationDto) throws JsonProcessingException {
        return ResponseEntity.ok(applicationService.updateApplication(applicationId, applicationDto));
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationId) throws JsonProcessingException {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.noContent().build();
    }
    
}