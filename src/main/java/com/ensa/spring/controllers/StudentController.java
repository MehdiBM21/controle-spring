package com.ensa.spring.controllers;

import com.ensa.spring.domain.model.Student;
import com.ensa.spring.domain.model.Teacher;
import com.ensa.spring.service.StudentService;
import com.ensa.spring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/front/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
        public String listStudent(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "listStudent";
    }



//    @PostMapping("/save")
//    public String saveStudent(Student student) {
//        studentService.addStudent(student);
//        return "redirect:/front/students/all";
//    }

    @GetMapping("/addStudentPage")
    public String getaddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student,
                             @RequestParam(value = "teacherIds",
                                     required = false) List<Long> teacherIds) {
        if(teacherIds != null) {
            List<Teacher> teachers = teacherService.getAllTeachers()
                    .stream()
                    .filter(teacher -> teacherIds.contains(teacher.getId()))
                    .collect(Collectors.toList());
            student.setTeachers(teachers);
        }

        studentService.addStudent(student);
        return "redirect:/front/students/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/front/students/all";
    }

}
