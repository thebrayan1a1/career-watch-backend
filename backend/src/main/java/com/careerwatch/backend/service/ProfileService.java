package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.profile.ProfileDto;
import com.careerwatch.backend.dto.resume.profile.UpdateProfileDto;

public interface ProfileService {
    ProfileDto getProfileByResumeId (Long resumeId);
    ProfileDto updateProfileByResumeId (Long resumeId, UpdateProfileDto profile);
    void deleteProfileByResumeId (Long resumeId);
}
