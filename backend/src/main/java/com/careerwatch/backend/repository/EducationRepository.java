package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<Education,Long> {
    List<Education> findAllByResumeId(Long resumeId);
}
