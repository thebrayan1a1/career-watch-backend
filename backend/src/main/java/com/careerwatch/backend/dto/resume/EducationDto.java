package com.careerwatch.backend.dto.resume;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EducationDto {
    private Long id;
    private Long resumeId;
    private String title;
    private String institution;
    private String dateStart;
    private String dateEnd;
    private String description;
}
