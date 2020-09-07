package com.provider.controller;


import com.provider.model.Department;
import com.provider.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
}
