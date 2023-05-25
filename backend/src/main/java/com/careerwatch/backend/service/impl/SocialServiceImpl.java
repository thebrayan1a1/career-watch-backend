package com.careerwatch.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.careerwatch.backend.dto.resume.SocialDto;
import com.careerwatch.backend.dto.resume.UpdateSocialDto;
import com.careerwatch.backend.entity.Social;
import com.careerwatch.backend.mapper.resume.SocialDtoMapper;
import com.careerwatch.backend.repository.SocialRepository;
import com.careerwatch.backend.service.SocialService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialServiceImpl implements SocialService {
    
    private final SocialRepository socialRepository;
    private final SocialDtoMapper mapper;
    
    @Override
    public List<SocialDto> getAllSocialsByResumeId(Long resumeId) {
        List<SocialDto> socials = mapper.entitiesToDtoList(socialRepository.findAllByResumeId(resumeId));
        return socials;
    }
    
    @Override
    public SocialDto getSocialById(Long socialId) {
        Social social = socialRepository.findById(socialId).orElseThrow(()->
                new RuntimeException("Error: social not found"));
        return mapper.entityToDto(social);
    }
    
    @Override
    public SocialDto updateSocialById(Long socialId, UpdateSocialDto socialDto) {
        Social social = socialRepository.findById(socialId).orElseThrow(()->
                new RuntimeException("Error: social not found"));
        
        socialDto.getTitle().ifPresent(social::setTitle);
        socialDto.getLink().ifPresent(social::setLink);
        
        socialRepository.save(social);
        return mapper.entityToDto(social);
    }
    
    @Override
    public void deleteSocialById(Long socialId) {
        if (socialRepository.existsById(socialId))
            throw new RuntimeException("Error: social " + socialId + " not found");
        socialRepository.deleteById(socialId);
    }
}
