package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.application.ApplicationDto;
import com.careerwatch.backend.dto.application.StageDto;
import com.careerwatch.backend.dto.application.UpdateStageDto;
import com.careerwatch.backend.entity.Application;
import com.careerwatch.backend.entity.Stage;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.application.StageDtoMapper;
import com.careerwatch.backend.repository.ApplicationRepository;
import com.careerwatch.backend.repository.StageRepository;
import com.careerwatch.backend.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {
    
    private final ApplicationRepository applicationRepository;
    private final StageRepository stageRepository;
    private final StageDtoMapper mapper;
    

    @Transactional
    @Override
    public List<StageDto> getAllStages() {
        return mapper.entitiesToDtoList(stageRepository.findAll());
    }

    @Transactional
    @Override
    public StageDto getStageById (Long id) {
        return mapper.entityToDto(stageRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Error: stage " + id + " not found")));
    }

    @Transactional
    @Override
    public StageDto updateStage (Long id, UpdateStageDto stageDto) {
        
        Stage stage = stageRepository.findById(id).orElseThrow(()->
                new RuntimeException("Error: stage not found"));

        stageDto.getStageName().ifPresent(stage::setStageName);
        
        List<Application> applicationList = new java.util.ArrayList<>(Collections.emptyList());

        if (!stageDto.getApplications().isEmpty()){
            for (ApplicationDto applicationDto : stageDto.getApplications()) {
                Application application = applicationRepository.findById(applicationDto.getId())
                        .orElseThrow(() -> new NotFoundException("Error: application not found"));
                applicationList.add(application);
            }
        stage.setApplications(applicationList);
        }

        stageRepository.save(stage);
        return mapper.entityToDto(stage);
    }

    @Transactional
    @Override
    public void deleteStage(Long stageId) {
        if (stageRepository.existsById(stageId))
            throw new RuntimeException("Error: stage " + stageId + " not found");
        stageRepository.deleteById(stageId);
    }

}
