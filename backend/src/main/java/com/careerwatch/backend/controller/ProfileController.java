package com.careerwatch.backend.controller;

import com.careerwatch.backend.dto.resume.profile.ProfileDto;
import com.careerwatch.backend.dto.resume.profile.UpdateProfileDto;
import com.careerwatch.backend.service.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    
    private final ProfileService profileService;

    @GetMapping("/{resumeId}")
    public ResponseEntity<ProfileDto> getProfileByResumeId(@PathVariable Long resumeId) throws JsonProcessingException {
        return ResponseEntity.ok(profileService.getProfileByResumeId(resumeId));
    }

    @PutMapping("/{resumeId}")
    public ResponseEntity<ProfileDto> updateProfileByResumeId(@PathVariable Long resumeId,
                                                              @RequestBody UpdateProfileDto profileDto) throws JsonProcessingException {
        return ResponseEntity.ok(profileService.updateProfileByResumeId(resumeId, profileDto));
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteProfileByResumeId(@PathVariable Long resumeId) throws JsonProcessingException {
        profileService.deleteProfileByResumeId(resumeId);
        return ResponseEntity.noContent().build();
    }
}
