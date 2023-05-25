package com.careerwatch.backend.service;

import java.util.List;

import com.careerwatch.backend.dto.resume.SocialDto;
import com.careerwatch.backend.dto.resume.UpdateSocialDto;

public interface SocialService {
    
    List<SocialDto> getAllSocialsByResumeId(Long resumeId);
    SocialDto getSocialById(Long socialId);
    SocialDto updateSocialById(Long socialId, UpdateSocialDto socialDto);
    void deleteSocialById(Long socialId);
    
}
