package data.provider.service;

import data.provider.dto.EmployeeDto;
import data.provider.mapper.EmployeeMapper;
import data.provider.model.Employee;
import data.provider.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployee() {
        return employeeRepo.findAll().stream()
                .map(employeeMapper::map)
                .collect(Collectors.toList());
    }
}
