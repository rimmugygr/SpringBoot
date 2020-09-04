package data.provider.controller;

import data.provider.dto.EmployeeDto;
import data.provider.service.EmployeeService;
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
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
    public EmployeeDto getAllEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}
