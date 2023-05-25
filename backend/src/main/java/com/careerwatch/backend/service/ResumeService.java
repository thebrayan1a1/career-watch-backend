package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.resume.ResumeDto;
import com.careerwatch.backend.dto.resume.resume.UpdateResumeDto;

import java.util.List;

public interface ResumeService {

    ResumeDto createResume (ResumeDto resumeDto);
    List<ResumeDto> getAllResumesByUserId (Long userId);
    ResumeDto getResumeById (Long resumeId);
    ResumeDto updateResumeById (Long resumeId, UpdateResumeDto resume);
    void deleteResumeById(Long id);
}
