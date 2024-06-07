package com.ensa.spring;

import com.ensa.spring.security.jwt.service.UserService;
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
	}

}
