package com.careerwatch.backend.dto.user;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateUserDto {
        @Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
                message = "Email direction isn't valid")
        private String email;
        private String profileImage;

        public Optional<String> getEmail(){
                return Optional.ofNullable(this.email);
        }
        public Optional<String> getProfileImage(){
                return Optional.ofNullable(this.profileImage);
        }
}
