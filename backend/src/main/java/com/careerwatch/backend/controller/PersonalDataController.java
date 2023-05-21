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
@RequestMapping("/api/v1/personalDatas")
public class PersonalDataController {
    
    private final personalDataService personalDataService;
    

    @GetMapping
    public ResponseEntity<List<personalDataDto>> getAllpersonalDatas() throws JsonProcessingException {
        return ResponseEntity.ok(personalDataService.getAllpersonalDatas());
    }

    @GetMapping("/{personalDataId}")
    public ResponseEntity<personalDataDto> getpersonalDataById(@PathVariable Long personalDataId) throws JsonProcessingException  {
        return ResponseEntity.ok(personalDataService.getpersonalDataById(personalDataId));
    }

    @PutMapping("/{personalDataId}")
    public ResponseEntity<personalDataDto> updatepersonalData(@PathVariable Long personalDataId, @ModelAttribute personalDataDto personalDataDto) throws JsonProcessingException {
        return ResponseEntity.ok(personalDataService.updatepersonalData(personalDataId, personalDataDto));
    }

    @DeleteMapping("/{personalDataId}")
    public ResponseEntity<Void> deletepersonalData(@PathVariable Long personalDataId) throws JsonProcessingException {
        personalDataService.deletepersonalData(personalDataId);
        return ResponseEntity.noContent().build();
    }

}
