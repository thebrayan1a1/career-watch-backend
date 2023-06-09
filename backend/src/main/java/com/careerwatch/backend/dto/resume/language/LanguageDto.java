package com.careerwatch.backend.dto.resume.language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LanguageDto {
    private Long id;
    private Long resumeId;
    private String language;
    private String languageLevel;

}
