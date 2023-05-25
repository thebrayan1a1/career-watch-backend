package com.careerwatch.backend.mapper.application;

import com.careerwatch.backend.dto.application.TaskDto;
import com.careerwatch.backend.entity.Application;
import com.careerwatch.backend.entity.Task;
import com.careerwatch.backend.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskDtoMapper {

    private final ApplicationRepository applicationRepository;
    public TaskDto entityToDto(Task task){
        return TaskDto.builder()
                .id(task.getId())
                .applicationId(task.getApplication().getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }

    public Task dtoToEntity(TaskDto taskDto){
        Application applicationTask = applicationRepository.findById(taskDto.getApplicationId())
                .orElseThrow(()-> new RuntimeException("Error: Application not found, orphan task"));

        return Task.builder()
                .application(applicationTask)
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .build();
    }

    public List<TaskDto> entitiesToDtoList (List<Task> tasks){

        List<TaskDto> listDtos = new ArrayList<>();
        for (Task task : tasks){
            listDtos.add(entityToDto(task));
        }
        return listDtos;
    }
}
