package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.ProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto getProfileId (Long ResumeId);
    ProfileDto updateProfile (Long ResumeId, ProfileDto profile);
    void deleteProfile(Long ResumeId);
}
