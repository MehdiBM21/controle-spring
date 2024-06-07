package com.ensa.spring;

import com.ensa.spring.domain.model.Skill;
import com.ensa.spring.security.jwt.service.UserService;
import com.ensa.spring.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	SkillService skillService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (userService.findByUsername("admin") == null) {
			Set<String> roles = new HashSet<>();
			roles.add("ROLE_ADMIN");
			userService.createUser("admin", "admin_password", roles);
		}

		if (skillService.getAllSkills().size()==0) {
			skillService.createSkill(new Skill("Java"));
			skillService.createSkill(new Skill("Spring"));
			skillService.createSkill(new Skill("Angular"));
			skillService.createSkill(new Skill("React"));
			skillService.createSkill(new Skill("JavaScript"));
		}
	}

}
