package com.careerwatch.backend.service;

import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.language.UpdateLanguageDto;

import java.util.List;

public interface LanguageService {

    LanguageDto createLanguage (LanguageDto languageDto);
    List<LanguageDto> getAllLanguagesByResumeId (Long ResumeId);
    LanguageDto getLanguageById (Long languageId);
    LanguageDto updateLanguageById (Long LanguageId, UpdateLanguageDto languageDto);
    void deleteLanguageById(Long languageId);
}
