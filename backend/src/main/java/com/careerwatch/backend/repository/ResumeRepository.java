package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Long> {

}
