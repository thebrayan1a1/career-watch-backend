package com.careerwatch.backend.dto.resume;\
import java.util.List;

public class ProfileDto {
    private Long id;
    private Long resumeId;
    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String location;
    private String imgResume;
    private List<SocialDto> socials;
}
