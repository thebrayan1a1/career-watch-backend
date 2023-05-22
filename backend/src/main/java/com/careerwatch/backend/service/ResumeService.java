package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.ResumeDto;

import java.util.List;

public interface ResumeService {

    List<ResumeDto> getAllResumes (Long userId);
    ResumeDto getResumeById (Long resumeId);
    ResumeDto updateResume (Long resumeId, ResumeDto resume);
    void deleteResume(Long id);
}
