package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.education.EducationDto;
import com.careerwatch.backend.dto.resume.education.UpdateEducationDto;

import java.util.List;

public interface EducationService {

    List<EducationDto> getAllEducations (Long ResumeId);
    EducationDto getEducation (Long educationId);

    EducationDto createEducation (EducationDto education);
    EducationDto updateEducation (Long educationId, UpdateEducationDto education);
    void deleteEducation (Long educationId);
}
