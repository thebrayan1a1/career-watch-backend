package com.careerwatch.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PROFILES")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESUME_ID", referencedColumnName = "ID")
    private Resume resume;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "Location")
    private String location;

    @Column(name = "IMG_RESUME")
    private String imgResume;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private List<Social> socials;
}
