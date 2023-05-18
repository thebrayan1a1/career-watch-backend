package com.careerwatch.backend.repository;

import com.careerwatch.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

}