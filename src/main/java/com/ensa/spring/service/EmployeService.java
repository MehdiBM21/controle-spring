package com.ensa.spring.service;

import com.ensa.spring.domain.model.Employe;
import com.ensa.spring.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }
    public List<Employe> getEmployes() {
        return employeRepository.findAll();
    }

    public void deleteEmploye(Employe employe) {
        employeRepository.delete(employe);
    }

}
