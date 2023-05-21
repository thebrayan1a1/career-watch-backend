package com.careerwatch.backend.dto.user;

import com.careerwatch.backend.dto.application.ApplicationDto;
import com.careerwatch.backend.dto.application.StageDto;
import com.careerwatch.backend.dto.resume.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String clientSince;
    private String profileImage;
    private List<ResumeDto> resumes;
    private List<StageDto> stages;
    private List<ApplicationDto> applications;
}
