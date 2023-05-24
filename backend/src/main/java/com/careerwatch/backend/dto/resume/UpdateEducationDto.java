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
public class UpdateEducationDto {
    private Long resumeId;
    private String title;
    private String institution;
    private String dateStart;
    private String dateEnd;
    private String description;

    public Optional<String> getTitle(){
        return Optional.ofNullable(this.title);
    }
    public Optional<String> getInstitution(){
        return Optional.ofNullable(this.institution);
    }
    public Optional<String> getDateStart(){
        return Optional.ofNullable(this.dateStart);
    }
    public Optional<String> getDateEnd(){
        return Optional.ofNullable(this.dateEnd);
    }
    public Optional<String> getDescription(){
        return Optional.ofNullable(this.description);
    }
}
