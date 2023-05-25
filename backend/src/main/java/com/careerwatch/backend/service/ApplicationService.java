package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.application.application.ApplicationDto;
import com.careerwatch.backend.dto.application.application.UpdateApplicationDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDto createApplication (ApplicationDto applicationDto);
    List<ApplicationDto> getAllApplicationsByUserId (Long userId);
    ApplicationDto getApplicationById (Long applicationId);
    ApplicationDto updateStageApplication (Long stageId, Long applicationId);
    ApplicationDto updateApplicationById (Long applicationId, UpdateApplicationDto application);
    void deleteApplicationById(Long applicationId);
}
