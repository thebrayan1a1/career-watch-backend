package com.careerwatch.backend.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StageDto {
    private Long id;
    private Long userId;
    private String stageName;
    private List<ApplicationDto> applications;
}
