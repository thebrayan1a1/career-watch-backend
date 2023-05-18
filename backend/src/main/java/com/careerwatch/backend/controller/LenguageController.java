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
@RequestMapping("/api/v1/lenguages")
public class LenguageController {
    
    private final LenguageService lenguageService;
    

    @GetMapping
    public ResponseEntity<List<LenguageDto>> getAllLenguages() throws JsonProcessingException {
        return ResponseEntity.ok(lenguageService.getAllLenguages());
    }

    @GetMapping("/{lenguageId}")
    public ResponseEntity<LenguageDto> getLenguageById(@PathVariable Long lenguageId) throws JsonProcessingException  {
        return ResponseEntity.ok(lenguageService.getLenguageById(lenguageId));
    }

    @PutMapping("/{lenguageId}")
    public ResponseEntity<LenguageDto> updateLenguage(@PathVariable Long lenguageId, @ModelAttribute LenguageDto lenguageDto) throws JsonProcessingException {
        return ResponseEntity.ok(lenguageService.updateLenguage(lenguageId, lenguageDto));
    }

    @DeleteMapping("/{lenguageId}")
    public ResponseEntity<Void> deleteLenguage(@PathVariable Long lenguageId) throws JsonProcessingException {
        lenguageService.deleteLenguage(lenguageId);
        return ResponseEntity.noContent().build();
    }
    
}
