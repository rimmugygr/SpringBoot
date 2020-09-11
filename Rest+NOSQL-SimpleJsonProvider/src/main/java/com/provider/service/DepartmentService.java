package com.provider.service;


import com.provider.model.Department;
import com.provider.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepo;

    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentByName(String name) {
        return departmentRepo.findDepartmentByName(name).orElseThrow(RuntimeException::new);
    }
}
