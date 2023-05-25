package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.resume.EducationDto;
import com.careerwatch.backend.dto.resume.UpdateEducationDto;
import com.careerwatch.backend.entity.Education;
import com.careerwatch.backend.exception.CantBeEmptyException;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.resume.EducationDtoMapper;
import com.careerwatch.backend.repository.EducationRepository;
import com.careerwatch.backend.repository.ResumeRepository;
import com.careerwatch.backend.service.EducationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final ResumeRepository resumeRepository;
    private final EducationDtoMapper mapper;

    @Transactional
    @Override
    public List<EducationDto> getAllEducations(Long resumeId) {
        if (resumeRepository.existsById(resumeId))
            throw new NotFoundException("Error: resume " + resumeId + " not found");
        return mapper.entitiesToDtoList(educationRepository.findAllByResumeId(resumeId));
    }

    @Transactional
    @Override
    public EducationDto getEducation(Long educationId) {
        return mapper.entityToDto(educationRepository.findById(educationId)
                .orElseThrow(()-> new NotFoundException("Error: education" + educationId + " not found")));
    }

    @Override
    public EducationDto createEducation(EducationDto education) {
        if (education.getResumeId() == null ) {
            throw new CantBeEmptyException("Error: resume Id is required");
        }
        Education newEducation = educationRepository.save(mapper.dtoToEntity(education));
        return mapper.entityToDto(newEducation);
    }

    @Transactional
    @Override
    public EducationDto updateEducation(Long educationId, UpdateEducationDto educationDto) {
        Education education = educationRepository.findById(educationId)
                .orElseThrow(()-> new NotFoundException("Error: education" + educationId + " not found"));

        educationDto.getTitle().ifPresent(education::setTitle);
        educationDto.getInstitution().ifPresent(education::setInstitution);
        educationDto.getDateStart().ifPresent(education::setDateStart);
        educationDto.getDateEnd().ifPresent(education::setDateEnd);
        educationDto.getDescription().ifPresent(education::setDescription);

        educationRepository.save(education);
        return mapper.entityToDto(education);
    }

    @Transactional
    @Override
    public void deleteEducation(Long educationId) {
        if (educationRepository.existsById(educationId))
            throw new NotFoundException("Error: Education " + educationId + " not found");
        educationRepository.deleteById(educationId);
    }
}
