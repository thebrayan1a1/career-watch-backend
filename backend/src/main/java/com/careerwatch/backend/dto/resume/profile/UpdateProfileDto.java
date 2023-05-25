package com.careerwatch.backend.dto.resume.profile;

import com.careerwatch.backend.dto.resume.SocialDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateProfileDto {
    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String location;
    private String imgResume;
    private List<SocialDto> socials;

    public Optional<String> getFullName(){
        return Optional.ofNullable(this.fullName);
    }
    public Optional<String> getTitle(){
        return Optional.ofNullable(this.title);
    }
    public Optional<String> getEmail(){
        return Optional.ofNullable(this.email);
    }
    public Optional<String> getPhone(){
        return Optional.ofNullable(this.phone);
    }
    public Optional<String> getLocation(){
        return Optional.ofNullable(this.location);
    }
    public Optional<String> getImgResume(){
        return Optional.ofNullable(this.imgResume);
    }
}
