package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Education;
import com.careerwatch.backend.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language,Long> {
    List<Language> findAllByResumeId(Long resumeId);
}
