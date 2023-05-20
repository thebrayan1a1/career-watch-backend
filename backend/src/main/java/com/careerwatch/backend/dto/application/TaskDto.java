package com.careerwatch.backend.dto.application;

import com.careerwatch.backend.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private Long applicationId;
    private String title;
    private String description;
}
