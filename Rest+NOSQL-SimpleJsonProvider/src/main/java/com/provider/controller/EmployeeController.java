package com.provider.controller;

import com.provider.model.Employee;
import com.provider.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    public Employee getAllEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }
}
