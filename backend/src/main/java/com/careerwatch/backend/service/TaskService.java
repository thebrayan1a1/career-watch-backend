package com.careerwatch.backend.service;
import com.careerwatch.backend.dto.application.TaskDto;
import com.careerwatch.backend.dto.application.UpdateTaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasksByApplicationId (Long applicationId);
    TaskDto getTaskById (Long taskId);
    TaskDto updateTaskById (Long taskId, UpdateTaskDto task);
    void deleteTaskById (Long taskId);



}
