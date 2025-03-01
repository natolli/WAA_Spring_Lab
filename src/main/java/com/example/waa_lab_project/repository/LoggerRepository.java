package com.example.waa_lab_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.waa_lab_project.model.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Long> {}