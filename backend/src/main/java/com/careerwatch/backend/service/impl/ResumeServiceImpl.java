package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.resume.experience.ExperienceDto;
import com.careerwatch.backend.dto.resume.language.LanguageDto;
import com.careerwatch.backend.dto.resume.profile.ProfileDto;
import com.careerwatch.backend.dto.resume.resume.ResumeDto;
import com.careerwatch.backend.dto.resume.resume.UpdateResumeDto;
import com.careerwatch.backend.entity.Experience;
import com.careerwatch.backend.entity.Language;
import com.careerwatch.backend.entity.Profile;
import com.careerwatch.backend.entity.Resume;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.resume.ExperienceDtoMapper;
import com.careerwatch.backend.mapper.resume.LanguageDtoMapper;
import com.careerwatch.backend.mapper.resume.ProfileDtoMapper;
import com.careerwatch.backend.mapper.resume.ResumeDtoMapper;
import com.careerwatch.backend.repository.ExperienceRepository;
import com.careerwatch.backend.repository.LanguageRepository;
import com.careerwatch.backend.repository.ProfileRepository;
import com.careerwatch.backend.repository.ResumeRepository;
import com.careerwatch.backend.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    private final ResumeDtoMapper mapper;
    private final ExperienceRepository experienceRepository;
    private final ProfileDtoMapper profileDtoMapper;
    private final ExperienceDtoMapper  experienceDtoMapper;
    private final LanguageDtoMapper languageDtoMapper;
    private final LanguageRepository languageRepository;
    private final ProfileRepository profileRepository;

    @Override
    public ResumeDto createResume(ResumeDto resumeDto) {
        Resume resume = mapper.dtoToEntity(resumeDto);
        resumeRepository.save(resume);
        return mapper.entityToDto(resume);
    }

    @Override
    public List<ResumeDto> getAllResumesByUserId(Long userId) {
        List<Resume> resumes = resumeRepository.findAllByUserId(userId);
        return mapper.entitiesToDtoList(resumes);
    }

    @Override
    public ResumeDto getResumeById(Long resumeId) {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new NotFoundException("Error: Resume not found"));
        return mapper.entityToDto(resume);
    }


    @Override
    public ResumeDto updateResumeById(Long resumeId, UpdateResumeDto resumeDto) {
        Resume existingResume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new NotFoundException("Error: Resume not found"));

        resumeDto.getPresentation().ifPresent(existingResume::setPresentation);
        resumeDto.getResumeName().ifPresent(existingResume::setResumeName);

        List<Experience> experiences = experienceRepository.findAllByResumeId(resumeId);
        List<Language> languages = languageRepository.findAllByResumeId(resumeId);
        Optional<Profile> profileOptional = profileRepository.findByResumeId(resumeId);

        if (profileOptional.isPresent()) {
            ProfileDto profileDto = profileDtoMapper.entityToDto(profileOptional.get());
            resumeDto.setProfile(profileDto);
        }
        if (!experiences.isEmpty()) {
            List<ExperienceDto> experienceDtos = experienceDtoMapper.entitiesToDtoList(experiences);
            resumeDto.setExperiences(experienceDtos);
        }
        if (!languages.isEmpty()) {
            List<LanguageDto> languageDtos = languageDtoMapper.entitiesToDtoList(languages);
            resumeDto.setLanguages(languageDtos);
        }

        Resume updatedResume = resumeRepository.save(existingResume);
        return mapper.entityToDto(updatedResume);
    }
    @Override
    public void deleteResumeById(Long id) {
        resumeRepository.deleteById(id);
    }
}
