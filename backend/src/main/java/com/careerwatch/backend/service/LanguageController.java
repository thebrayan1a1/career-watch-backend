package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.LanguageDto;

import java.util.List;

public interface LanguageController {
    List<LanguageDto> getAllLanguages (Long ResumeId);
    LanguageDto getLanguage (Long languageId);
    LanguageDto updateLanguage (Long LanguageId, LanguageDto language);
    void deleteLanguage(Long languageId);
}
