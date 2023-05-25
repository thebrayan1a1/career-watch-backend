package com.careerwatch.backend.mapper.user;

import com.careerwatch.backend.dto.application.application.ApplicationDto;
import com.careerwatch.backend.dto.application.stage.StageDto;
import com.careerwatch.backend.dto.resume.resume.ResumeDto;
import com.careerwatch.backend.dto.user.UserDto;
import com.careerwatch.backend.entity.User;
import com.careerwatch.backend.mapper.application.ApplicationDtoMapper;
import com.careerwatch.backend.mapper.application.StageDtoMapper;
import com.careerwatch.backend.mapper.resume.ResumeDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class UserDtoMapper {
    private final ResumeDtoMapper resumeDtoMapper;
    private final StageDtoMapper stageDtoMapper;
    private final ApplicationDtoMapper applicationDtoMapper;
    public UserDto entityToDto(User user) {

        List<ResumeDto> resumeDtoList = Optional.ofNullable(user.getResumes())
                .orElse(emptyList())
                .stream()
                .map(resumeDtoMapper::entityToDto)
                .toList();

        List<StageDto> stageDtoList = Optional.ofNullable(user.getStages())
                .orElse(Collections.emptyList())
                .stream()
                .map(stageDtoMapper::entityToDto)
                .toList();

        List<ApplicationDto> applicationsDtoList = Optional.ofNullable(user.getApplications())
                .orElse(Collections.emptyList())
                .stream()
                .map(applicationDtoMapper::entityToDto)
                .toList();

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .clientSince(user.getClientSince())
                .profileImage(user.getProfileImage())
                .resumes(resumeDtoList)
                .stages(stageDtoList)
                .applications(applicationsDtoList)
                .build();
    }
    public List<UserDto> entitiesToDtoList(List<User> users ) {

        List<UserDto> listUsersDto = new ArrayList<>(emptyList());

        for (User user : users) {
            listUsersDto.add(entityToDto(user));
        }
        return listUsersDto;
    }

}