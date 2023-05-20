package com.careerwatch.backend.dto.resume;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResumeDto {
    private Long id;
    private Long userId;
    private String presentation;
    private String resumeName;
    private ProfileDto profile;
    private List<EducationDto> educations;
    private List<ExperienceDto> experiences;
    private List<LanguageDto> languages;
}
