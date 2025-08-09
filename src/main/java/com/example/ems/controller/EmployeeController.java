package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return service.create(emp);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        return service.update(id, emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

