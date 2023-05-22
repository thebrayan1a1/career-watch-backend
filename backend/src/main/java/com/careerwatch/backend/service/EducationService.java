package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.EducationDto;

import java.util.List;

public interface EducationService {

    List<EducationDto> getAllEducations (Long ResumeId);
    EducationDto getEducation (Long educationId);
    EducationDto updateEducation (Long educationId, EducationDto education);
    void deleteEducation (Long educationId);
}
