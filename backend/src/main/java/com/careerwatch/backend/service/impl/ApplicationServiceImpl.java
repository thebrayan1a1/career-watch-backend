package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.application.application.ApplicationDto;
import com.careerwatch.backend.dto.application.application.UpdateApplicationDto;
import com.careerwatch.backend.entity.Application;
import com.careerwatch.backend.entity.Stage;
import com.careerwatch.backend.entity.Task;
import com.careerwatch.backend.entity.User;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.application.ApplicationDtoMapper;
import com.careerwatch.backend.mapper.application.TaskDtoMapper;
import com.careerwatch.backend.repository.ApplicationRepository;
import com.careerwatch.backend.repository.StageRepository;
import com.careerwatch.backend.repository.UserRepository;
import com.careerwatch.backend.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationDtoMapper mapper;
    private final UserRepository userRepository;
    private final StageRepository stageRepository;
    private final TaskDtoMapper taskMapper;

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = mapper.dtoToEntity(applicationDto);
        applicationRepository.save(application);
        return mapper.entityToDto(application);
    }

    @Override
    public List<ApplicationDto> getAllApplicationsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("Error: user with id " + userId + " not found"));
        return mapper.entityToDtoList(user.getApplications());
    }

    @Override
    public ApplicationDto getApplicationById(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(()-> new NotFoundException("Error: application with id " + applicationId + " not found"));
        return mapper.entityToDto(application);
    }

    @Override
    public ApplicationDto updateStageApplication(Long stageId, Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(()-> new NotFoundException("Error: application with id " + applicationId + " not found"));
        Stage stage = stageRepository.findById(stageId)
                .orElseThrow(()-> new NotFoundException("Error: stage with id " + stageId + " not found"));
        application.setStage(stage);
        return mapper.entityToDto(application);
    }

    @Override
    public ApplicationDto updateApplicationById(Long applicationId, UpdateApplicationDto application) {
        Application existingApplication = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Error: application with id " + applicationId + " not found"));

        application.getUserId().ifPresent(userId -> {
            User userApplication = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Error: user with id " + userId + " not found"));
            existingApplication.setUser(userApplication);
        });

        application.getStageId().ifPresent(stageId -> {
            Stage stageApplication = stageRepository.findById(stageId)
                    .orElseThrow(() -> new RuntimeException("Error: Stage with id " + stageId + " not found"));
            existingApplication.setStage(stageApplication);
        });

        application.getTasks().ifPresent(tasks -> {
            List<Task> taskList = tasks.stream()
                    .map(taskMapper::dtoToEntity)
                    .collect(Collectors.toList());
            existingApplication.setTasks(taskList);
        });

        application.getPosition().ifPresent(existingApplication::setPosition);
        application.getDescription().ifPresent(existingApplication::setDescription);
        application.getApplicationDate().ifPresent(existingApplication::setApplicationDate);
        application.getCompany().ifPresent(existingApplication::setCompany);
        application.getResumeName().ifPresent(existingApplication::setResumeName);

        Application updatedApplication = applicationRepository.save(existingApplication);

        return mapper.entityToDto(updatedApplication);
    }

    @Override
    public void deleteApplicationById(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
