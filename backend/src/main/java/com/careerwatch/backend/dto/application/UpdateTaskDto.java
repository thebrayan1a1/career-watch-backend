package com.careerwatch.backend.dto.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateTaskDto {
    private Long applicationId;
    private String title;
    private String description;

    public Optional<Long> getApplicationId(){
        return Optional.ofNullable(this.applicationId);
    }
    public Optional<String> getTitle(){
        return Optional.ofNullable(this.title);
    }
    public Optional<String> getDescription(){
        return Optional.ofNullable(this.description);
    }
}
