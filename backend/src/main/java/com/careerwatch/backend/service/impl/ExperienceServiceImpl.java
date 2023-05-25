package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.resume.experience.ExperienceDto;
import com.careerwatch.backend.entity.Experience;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.resume.ExperienceDtoMapper;
import com.careerwatch.backend.repository.ExperienceRepository;
import com.careerwatch.backend.repository.ResumeRepository;
import com.careerwatch.backend.repository.UserRepository;
import com.careerwatch.backend.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final ExperienceDtoMapper mapper;

    @Override
    public ExperienceDto createExperience(ExperienceDto experienceDto) {
        Experience experience = mapper.dtoToEntity(experienceDto);
        experienceRepository.save(experience);
        return mapper.entityToDto(experience);
    }

    @Override
    public List<ExperienceDto> getAllExperiencesByResumeId(Long resumeId) {
        List<Experience> experiences = experienceRepository.findAllByResumeId(resumeId);
        return mapper.entitiesToDtoList(experiences);
    }

    @Override
    public ExperienceDto getExperienceById(Long experienceId) {
        Experience experience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new NotFoundException("Error: Experience not found"));
        return mapper.entityToDto(experience);
    }

    @Override
    public ExperienceDto updateExperienceById(Long experienceId, ExperienceDto experienceDto) {
        Experience existingExperience = experienceRepository.findById(experienceId)
                .orElseThrow(() -> new NotFoundException("Error: Experience not found"));

        existingExperience.setTitle(experienceDto.getTitle());
        existingExperience.setCompany(experienceDto.getCompany());
        existingExperience.setDateStart(experienceDto.getDateStart());
        existingExperience.setDateEnd(experienceDto.getDateEnd());
        existingExperience.setDescription(experienceDto.getDescription());

        Experience updatedExperience = experienceRepository.save(existingExperience);
        return mapper.entityToDto(updatedExperience);
    }
    @Override
    public void deleteExperienceById(Long experienceId) {
        experienceRepository.deleteById(experienceId);
    }
}
