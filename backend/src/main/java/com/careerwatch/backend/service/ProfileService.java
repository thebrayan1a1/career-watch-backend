package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.ProfileDto;
import com.careerwatch.backend.dto.resume.UpdateProfileDto;

import java.util.List;

public interface ProfileService {
    ProfileDto getProfileByResumeId (Long resumeId);
    ProfileDto updateProfileByResumeId (Long resumeId, UpdateProfileDto profile);
    void deleteProfileByResumeId (Long resumeId);
}
