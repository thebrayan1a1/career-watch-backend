package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
