package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.application.ApplicationDto;
import com.careerwatch.backend.dto.resume.LanguageDto;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDto> getAllApplications (Long userId);
    ApplicationDto getApplication (Long applicationId);
    ApplicationDto updateStageApplication (Long stageId, Long applicationId);
    ApplicationDto updateApplication (Long applicationId, ApplicationDto application);
    void deleteApplication(Long applicationId);
}
