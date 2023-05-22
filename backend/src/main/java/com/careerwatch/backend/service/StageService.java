package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.application.StageDto;

import java.util.List;

public interface StageService {
    List<StageDto> getAllStages ();
    StageDto getStageById (Long id);
    StageDto updateStage (Long id, StageDto stage);
    void deleteStage(Long id);

}
