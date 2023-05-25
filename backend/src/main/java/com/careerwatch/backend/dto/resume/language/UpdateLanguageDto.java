package com.careerwatch.backend.dto.resume.language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateLanguageDto {
    private String language;
    private String languageLevel;

    public Optional<String> getLanguage() {
        return Optional.ofNullable(this.language);
    }

    public Optional<String> getLanguageLevel() {
        return Optional.ofNullable(this.languageLevel);
    }
}
