package com.ensa.spring.controllers;

import com.ensa.spring.domain.model.Employe;
import com.ensa.spring.service.EmployeService;
import com.ensa.spring.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employes")
public class EmployeController {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private SkillService skillService;

    @GetMapping("/all")
    public String getEmployes(Model model) {
        List<Employe> employes = employeService.getEmployes();
        model.addAttribute("employes", employes);
        return "listEmploye";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employe", new Employe());
        model.addAttribute("skills", skillService.getAllSkills());
        return "addEmploye";
    }

    @PostMapping("/new")
    public String createEmploye(@ModelAttribute Employe employe, Model model) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return "redirect:/employes/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable Long id, Model model) {
        Employe employe = employeService.getEmployeById(id);
        if (employe == null) {
            return "error/404";
        }

        employeService.deleteEmploye(employe);
        return "redirect:/employes/all";
    }
}
