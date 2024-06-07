package com.ensa.spring.service;


import com.ensa.spring.domain.model.Skill;
import com.ensa.spring.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }


    public Skill getSkillById(Long id) {
        Optional<Skill> skill = skillRepository.findById(id);
        return skill.orElse(null);
    }


    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }


    public Skill updateSkill(Long id, Skill skill) {
        if (skillRepository.existsById(id)) {
            skill.setId(id);
            return skillRepository.save(skill);
        }
        return null;
    }


    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
