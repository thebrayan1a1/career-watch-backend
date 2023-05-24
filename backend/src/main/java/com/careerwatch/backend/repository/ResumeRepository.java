package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ResumeRepository extends JpaRepository<Resume,Long> {

}
