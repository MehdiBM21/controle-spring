package com.ensa.spring.security.jwt.service;

import com.ensa.spring.security.jwt.domain.model.MyUser;
import com.ensa.spring.security.jwt.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private MyUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MyUser createUser(String username, String password, Set<String> roles) {
        MyUser user = new MyUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public MyUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
