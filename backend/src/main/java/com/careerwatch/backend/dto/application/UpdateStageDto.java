package com.careerwatch.backend.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateStageDto {

    private String stageName;
    private List<Appli

    public Optional<String> getStageName() {
        return Optional.ofNullable(stageName);
    }

    public Optional<List<ApplicationDto>> getApplications() {
        return Optional.ofNullable(applications);
    }
    
}