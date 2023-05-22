package com.careerwatch.backend.controller;

import com.careerwatch.backend.service.StageService;
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
@RequestMapping("/api/v1/stages")
public class StageController {
    
    private final StageService stageService;
    

    @GetMapping
    public ResponseEntity<List<StageDto>> getAllStages() throws JsonProcessingException {
        return ResponseEntity.ok(stageService.getAllStages());
    }

    @GetMapping("/{stageId}")
    public ResponseEntity<StageDto> getStageById(@PathVariable Long stageId) throws JsonProcessingException  {
        return ResponseEntity.ok(stageService.getStageById(stageId));
    }

    @PutMapping("/{stageId}")
    public ResponseEntity<StageDto> updateStage(@PathVariable Long stageId, @ModelAttribute StageDto stageDto) throws JsonProcessingException {
        return ResponseEntity.ok(stageService.updateStage(stageId, stageDto));
    }

    @DeleteMapping("/{stageId}")
    public ResponseEntity<Void> deleteStage(@PathVariable Long stageId) throws JsonProcessingException {
        stageService.deleteStage(stageId);
        return ResponseEntity.noContent().build();
    }
    
}
