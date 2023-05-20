package com.careerwatch.backend.dto.user;

import com.careerwatch.backend.entity.Application;
import com.careerwatch.backend.entity.Resume;
import com.careerwatch.backend.entity.Stage;
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
    private List<Resume> resumes;
    private List<Stage> stages;
    private List<Application> applications;

}
