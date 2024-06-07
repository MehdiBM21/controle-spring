package com.ensa.spring.repository;

import com.ensa.spring.domain.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
