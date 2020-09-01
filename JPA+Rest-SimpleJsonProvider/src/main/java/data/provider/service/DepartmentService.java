package data.provider.service;

import data.provider.dto.DepartmentDto;
import data.provider.mapper.DepartmentMapper;
import data.provider.model.Department;
import data.provider.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepo;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDto> getAllDepartment() {
        return departmentRepo.findAll().stream()
                .map(departmentMapper::map)
                .collect(Collectors.toList());
    }
}
