package com.ensa.spring.repository;

import com.ensa.spring.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
