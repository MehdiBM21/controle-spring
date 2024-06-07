package com.ensa.spring.controllers;


import com.ensa.spring.domain.model.Teacher;
import com.ensa.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/addTeacherPage")
    public String showAddTeacherPage(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @PostMapping("/add")
    public String addTeacher(Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "redirect:/front/students/all";
    }
}
