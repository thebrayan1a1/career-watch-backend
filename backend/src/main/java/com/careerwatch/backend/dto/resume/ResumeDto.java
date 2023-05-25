package com.careerwatch.backend.dto.resume;

import com.careerwatch.backend.dto.resume.education.EducationDto;
import com.careerwatch.backend.dto.resume.experience.ExperienceDto;
import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.profile.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
