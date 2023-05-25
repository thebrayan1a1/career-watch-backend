package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.language.UpdateLanguageDto;
import com.careerwatch.backend.entity.Language;
import com.careerwatch.backend.enumeration.ELanguage;
import com.careerwatch.backend.enumeration.ELanguageLevel;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.resume.LanguageDtoMapper;
import com.careerwatch.backend.repository.LanguageRepository;
import com.careerwatch.backend.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageDtoMapper mapper;
    private final LanguageRepository languageRepository;

    @Override
    public LanguageDto createLanguage(LanguageDto languageDto) {
        Language language = mapper.dtoToEntity(languageDto);
        languageRepository.save(language);
        return mapper.entityToDto(language);
    }

    @Override
    public List<LanguageDto> getAllLanguagesByResumeId(Long resumeId) {
        List<Language> languages = languageRepository.findAllByResumeId(resumeId);
        return mapper.entitiesToDtoList(languages);
    }


    @Override
    public LanguageDto getLanguageById(Long languageId) {
        Language language = languageRepository.findById(languageId)
                .orElseThrow(() -> new NotFoundException("Error: Language not found"));
        return mapper.entityToDto(language);
    }

    @Override
    public LanguageDto updateLanguageById(Long languageId, UpdateLanguageDto languageDto) {
        Language existingLanguage = languageRepository.findById(languageId)
                .orElseThrow(() -> new NotFoundException("Error: Language not found"));

        languageDto.getLanguage().ifPresent(language -> {
            ELanguage updatedLanguage = ELanguage.valueOf(language.toUpperCase());
            existingLanguage.setLanguage(updatedLanguage);
        });

        languageDto.getLanguageLevel().ifPresent(languageLevel -> {
            ELanguageLevel updatedLanguageLevel = ELanguageLevel.valueOf(languageLevel.toUpperCase());
            existingLanguage.setLanguageLevel(updatedLanguageLevel);
        });

        Language updatedLanguage = languageRepository.save(existingLanguage);
        return mapper.entityToDto(updatedLanguage);
    }

    @Override
    public void deleteLanguageById(Long languageId) {
        languageRepository.deleteById(languageId);
    }
}
