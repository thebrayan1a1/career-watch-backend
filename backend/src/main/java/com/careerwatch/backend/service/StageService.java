package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.application.StageDto;
import com.careerwatch.backend.dto.application.UpdateStageDto;

import java.util.List;

public interface StageService {
    List<StageDto> getAllStages ();
    StageDto getStageById (Long id);
    StageDto updateStage (Long id, UpdateStageDto stage);
    void deleteStage(Long id);

}
