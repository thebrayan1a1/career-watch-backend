package com.careerwatch.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EXPERIENCES")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "RESUME_ID")
    private Long resumeId;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "DATE_START")
    private String dateStart;

    @Column(name = "DATE_END")
    private String dateEnd;

    @Column(name = "DESCRIPTION")
    private String description;
}