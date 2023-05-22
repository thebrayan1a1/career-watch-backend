package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Social;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialRepository extends JpaRepository<Social,Long> {
}
