package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.application.StageDto;
import com.careerwatch.backend.entity.User;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.application.StageDtoMapper;
import com.careerwatch.backend.repository.UserRepository;
import com.careerwatch.backend.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StageServiceImpl implements StageService {

    private final StageDtoMapper mapper;
    private final UserRepository userRepository;

    @Override
    public List<StageDto> getAllStagesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("Error: user with id " + userId + " not found"));
        return null;
    }

    @Override
    public StageDto getStageById(Long stageId) {
        return null;
    }

    @Override
    public StageDto updateStageById(Long stageId, StageDto stage) {
        return null;
    }

    @Override
    public void deleteStageById(Long stageId) {

    }
}
