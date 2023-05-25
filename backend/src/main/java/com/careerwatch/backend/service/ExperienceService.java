package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.experience.ExperienceDto;

import java.util.List;

public interface ExperienceService {

    ExperienceDto createExperience (ExperienceDto experienceDto);
    List<ExperienceDto> getAllExperiencesByResumeId (Long ResumeId);
    ExperienceDto getExperienceById (Long experienceId);
    ExperienceDto updateExperienceById (Long experienceId, ExperienceDto experienceDto);
    void deleteExperienceById (Long experienceId);
}
