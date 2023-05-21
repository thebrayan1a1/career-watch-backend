package com.careerwatch.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Languages")
public class LanguageController {
    
    private final LanguageService languageService;
    

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAllLanguages() throws JsonProcessingException {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @GetMapping("/{LanguageId}")
    public ResponseEntity<LanguageDto> getLanguageById(@PathVariable Long LanguageId) throws JsonProcessingException  {
        return ResponseEntity.ok(languageService.getLanguageById(LanguageId));
    }

    @PutMapping("/{LanguageId}")
    public ResponseEntity<LanguageDto> updateLanguage(@PathVariable Long LanguageId, @ModelAttribute LanguageDto LanguageDto) throws JsonProcessingException {
        return ResponseEntity.ok(languageService.updateLanguage(LanguageId, LanguageDto));
    }

    @DeleteMapping("/{LanguageId}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long LanguageId) throws JsonProcessingException {
        LanguageService.deleteLanguage(LanguageId);
        return ResponseEntity.noContent().build();
    }
    
}
