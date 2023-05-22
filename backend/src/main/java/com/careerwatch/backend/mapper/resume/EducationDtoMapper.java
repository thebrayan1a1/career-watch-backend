package com.careerwatch.backend.mapper.resume;

import com.careerwatch.backend.dto.resume.EducationDto;
import com.careerwatch.backend.entity.Education;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EducationDtoMapper {

    public EducationDto entityToDto(Education education){
        return EducationDto.builder()
                .id(education.getId())
                .resumeId(education.getResumeId())
                .title(education.getTitle())
                .institution(education.getInstitution())
                .dateStart(education.getDateStart())
                .dateEnd(education.getDateEnd())
                .description(education.getDescription())
                .build();
    }

    public Education dtoToEntity(EducationDto educationDto) {
        return Education.builder()
                .resumeId(educationDto.getResumeId())
                .title(educationDto.getTitle())
                .institution(educationDto.getInstitution())
                .dateStart(educationDto.getDateStart())
                .dateEnd(educationDto.getDateEnd())
                .description(educationDto.getDescription())
                .build();
    }
}
