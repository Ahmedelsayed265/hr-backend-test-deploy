package com.jpa.hr.services;

import com.jpa.hr.entities.Employee;
import com.jpa.hr.repositries.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
