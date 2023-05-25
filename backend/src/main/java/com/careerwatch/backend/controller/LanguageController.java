package com.careerwatch.backend.controller;

import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.language.UpdateLanguageDto;
import com.careerwatch.backend.service.LanguageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Languages")
public class LanguageController {
    
    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody LanguageDto languageDto) throws JsonProcessingException {
        return ResponseEntity.ok(languageService.createLanguage(languageDto));
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<List<LanguageDto>> getAllLanguagesByResumeId(@PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(languageService.getAllLanguagesByResumeId(resumeId));
    }

    @GetMapping("/{languageId}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Long LanguageId) throws JsonProcessingException  {
        return ResponseEntity.ok(languageService.getLanguageById(LanguageId));
    }

    @PutMapping("/{languageId}")
    public ResponseEntity<LanguageDto> updateLanguage(@PathVariable Long LanguageId, @RequestBody UpdateLanguageDto LanguageDto) throws JsonProcessingException {
        return ResponseEntity.ok(languageService.updateLanguageById(LanguageId, LanguageDto));
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long LanguageId) throws JsonProcessingException {
        languageService.deleteLanguageById(LanguageId);
        return ResponseEntity.noContent().build();
    }
    
}
