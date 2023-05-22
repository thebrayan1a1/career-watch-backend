package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.ExperienceDto;

import java.util.List;

public interface ExperienceService {

    List<ExperienceDto> getAllExperiences (Long ResumeId);
    ExperienceDto getExperience (Long experienceId);
    ExperienceDto updateExperience (Long experienceId, ExperienceDto experience);
    void deleteExperience (Long experienceId);
}
