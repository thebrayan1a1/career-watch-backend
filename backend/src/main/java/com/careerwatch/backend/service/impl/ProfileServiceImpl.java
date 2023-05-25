package com.careerwatch.backend.service.impl;

import com.careerwatch.backend.dto.resume.ProfileDto;
import com.careerwatch.backend.dto.resume.SocialDto;
import com.careerwatch.backend.dto.resume.UpdateProfileDto;
import com.careerwatch.backend.entity.Profile;
import com.careerwatch.backend.entity.Social;
import com.careerwatch.backend.exception.NotFoundException;
import com.careerwatch.backend.mapper.resume.ProfileDtoMapper;
import com.careerwatch.backend.mapper.resume.SocialDtoMapper;
import com.careerwatch.backend.repository.ProfileRepository;
import com.careerwatch.backend.repository.ResumeRepository;
import com.careerwatch.backend.service.ProfileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final ResumeRepository resumeRepository;
    private final ProfileDtoMapper mapper;
    private final ProfileRepository profileRepository;
    private final SocialDtoMapper socialMapper;

    @Transactional
    @Override
    public ProfileDto getProfileByResumeId(Long resumeId) {
        if (!resumeRepository.existsById(resumeId))
            throw new NotFoundException("Error: resume " + resumeId + " not found");
        return mapper.entityToDto(profileRepository.findByResumeId(resumeId)
                .orElseThrow(()-> new NotFoundException("Error: profile in resume id " + resumeId + " not found")));
    }
    @Transactional
    @Override
    public ProfileDto updateProfileByResumeId(Long resumeId, UpdateProfileDto profileDto) {
        Profile profile = profileRepository.findByResumeId(resumeId)
                .orElseThrow(()-> new NotFoundException("Error: profile in resume id " + resumeId + " not found"));

        profileDto.getFullName().ifPresent(profile::setFullName);
        profileDto.getTitle().ifPresent(profile::setTitle);
        profileDto.getEmail().ifPresent(profile::setEmail);
        profileDto.getPhone().ifPresent(profile::setPhone);
        profileDto.getLocation().ifPresent(profile::setLocation);
        profileDto.getImgResume().ifPresent(profile::setImgResume);

        List<Social> socialList = new java.util.ArrayList<>(Collections.emptyList());

        if (!profileDto.getSocials().isEmpty()){
            for (SocialDto socialDto : profileDto.getSocials()) {
                Social social = socialMapper.dtoToEntity(socialDto);
                socialList.add(social);
            }
        profile.setSocials(socialList);
        }

        profileRepository.save(profile);
        return mapper.entityToDto(profile);
    }

    @Transactional
    @Override
    public void deleteProfileByResumeId(Long resumeId) {
        Profile profile = profileRepository.findByResumeId(resumeId)
                .orElseThrow(()-> new NotFoundException("Error: profile in resume id " + resumeId + " not found"));
        profileRepository.delete(profile);
    }
}
