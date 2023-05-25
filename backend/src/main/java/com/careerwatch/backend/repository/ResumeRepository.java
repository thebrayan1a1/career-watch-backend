package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Language;
import com.careerwatch.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ResumeRepository extends JpaRepository<Resume,Long> {
    List<Resume> findAllByUserId(Long UserId);
}
