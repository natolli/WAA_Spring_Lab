package com.example.waa_lab_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.waa_lab_project.model.ExceptionLog;

public interface ExceptionLogRepository extends JpaRepository<ExceptionLog, Long> {}