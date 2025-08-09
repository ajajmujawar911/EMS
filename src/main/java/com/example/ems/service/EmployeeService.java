package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee create(Employee emp) {
        return repo.save(emp);
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = getById(id);
        if (existing != null) {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setRole(emp.getRole());
            return repo.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

