package data.provider.controller;

import data.provider.dto.EmployeeDto;
import data.provider.model.Employee;
import data.provider.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
