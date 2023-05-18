package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Education,Long> {
}
