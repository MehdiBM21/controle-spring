package com.ensa.spring.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

    @GetMapping("/user")
    public String index() {
        return "listStudent";
    }
    @GetMapping("/customLogin")
    public String login() {
        return "CustomLogin";
    }

    @GetMapping("/")
    public String loginPage() {
        return "CustomLogin";
    }




}
