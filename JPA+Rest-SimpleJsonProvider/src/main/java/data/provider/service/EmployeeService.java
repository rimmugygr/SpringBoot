package data.provider.service;

import data.provider.dto.EmployeeDto;
import data.provider.mapper.EmployeeMapper;
import data.provider.model.Employee;
import data.provider.model.Task;
import data.provider.repository.EmployeeRepository;
import data.provider.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepo;
    private final TaskRepository taskRepo;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = employeeRepo.findAll().stream()
                .map(employeeMapper::map)
                .collect(Collectors.toList());
        employeeDtoList.forEach(
                x -> x.setTaskIds(
                        taskRepo.findAllByEmployeeId(
                                x.getId()).stream()
                                .map(Task::getId)
                                .collect(Collectors.toSet())
                )
        );
        return employeeDtoList;
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeeDto employDto = employeeMapper.map(employeeRepo.findById(id).orElseThrow(RuntimeException::new));
        employDto.setTaskIds(
                taskRepo.findAllByEmployeeId(id).stream()
                .map(Task::getId)
                .collect(Collectors.toSet()));
        return employDto;
    }
}
