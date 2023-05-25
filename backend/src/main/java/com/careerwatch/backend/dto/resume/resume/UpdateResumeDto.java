package com.careerwatch.backend.dto.resume.resume;

import com.careerwatch.backend.dto.resume.education.EducationDto;
import com.careerwatch.backend.dto.resume.experience.ExperienceDto;
import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.profile.ProfileDto;
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
public class UpdateResumeDto {
    private Long userId;
    private String presentation;
    private String resumeName;
    private ProfileDto profile;
    private List<EducationDto> educations;
    private List<ExperienceDto> experiences;
    private List<LanguageDto> languages;

    public Optional<String> getPresentation() {
        return Optional.ofNullable(this.presentation);
    }

    public Optional<String> getResumeName() {
        return Optional.ofNullable(this.resumeName);
    }

    public Optional<ProfileDto> getProfile() {
        return Optional.ofNullable(this.profile);
    }

    public Optional<List<EducationDto>> getEducations() {
        return Optional.ofNullable(this.educations);
    }

    public Optional<List<ExperienceDto>> getExperiences() {
        return Optional.ofNullable(this.experiences);
    }

    public Optional<List<LanguageDto>> getLanguages() {
        return Optional.ofNullable(this.languages);
    }
}
