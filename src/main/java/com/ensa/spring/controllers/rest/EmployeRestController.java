package com.ensa.spring.controllers.rest;

import com.ensa.spring.domain.model.Employe;
import com.ensa.spring.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeRestController {

    @Autowired
    private EmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return new ResponseEntity<>(createdEmploye, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id);
        if (employe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employe, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getEmployes() {
        List<Employe> employes = employeService.getEmployes();
        return new ResponseEntity<>(employes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id);
        if (employe == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeService.deleteEmploye(employe);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
