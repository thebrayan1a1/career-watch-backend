package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage,Long> {
}
