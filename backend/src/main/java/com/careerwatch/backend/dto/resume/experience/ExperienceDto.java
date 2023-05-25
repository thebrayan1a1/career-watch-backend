package com.careerwatch.backend.dto.resume.experience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ExperienceDto {
    private Long id;
    private Long resumeId;
    private String title;
    private String company;
    private String dateStart;
    private String dateEnd;
    private String description;
}
