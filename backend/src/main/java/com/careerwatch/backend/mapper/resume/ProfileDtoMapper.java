package com.careerwatch.backend.mapper.resume;

import com.careerwatch.backend.dto.resume.ProfileDto;
import com.careerwatch.backend.dto.resume.SocialDto;
import com.careerwatch.backend.entity.Profile;
import com.careerwatch.backend.entity.Resume;
import com.careerwatch.backend.entity.Social;
import com.careerwatch.backend.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfileDtoMapper {

    private final SocialDtoMapper socialDtoMapper;
    private final ResumeRepository resumeRepository;
    public ProfileDto entityToDto (Profile profile) {

        List<SocialDto> socialDtos = profile.getSocials().stream().map(
                socialDtoMapper::entityToDto
        ).toList();

        return ProfileDto.builder()
                .id(profile.getId())
                .resumeId(profile.getResume().getId())
                .fullName(profile.getFullName())
                .title(profile.getTitle())
                .email(profile.getEmail())
                .phone(profile.getPhone())
                .location(profile.getLocation())
                .imgResume(profile.getImgResume())
                .socials(socialDtos)
                .build();
    }

    public Profile dtoToEntity (ProfileDto profileDto){

        Resume resume = resumeRepository.findById(profileDto.getResumeId())
                .orElseThrow(()-> new RuntimeException("Resume not found"));

        List<Social> socialList = profileDto.getSocials().stream().map(
                socialDtoMapper::dtoToEntity)
                .toList();

        return Profile.builder()
                .resume(resume)
                .email(profileDto.getEmail())
                .fullName(profileDto.getFullName())
                .title(profileDto.getTitle())
                .phone(profileDto.getPhone())
                .location(profileDto.getLocation())
                .imgResume(profileDto.getImgResume())
                .socials(socialList)
                .build();


    }


}
