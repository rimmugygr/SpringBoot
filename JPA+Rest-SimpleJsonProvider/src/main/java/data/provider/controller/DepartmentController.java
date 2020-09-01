package data.provider.controller;

import data.provider.dto.DepartmentDto;
import data.provider.model.Department;
import data.provider.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
}
