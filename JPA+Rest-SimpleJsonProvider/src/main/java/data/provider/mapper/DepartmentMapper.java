package data.provider.mapper;

import data.provider.dto.DepartmentDto;
import data.provider.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department map(DepartmentDto departmentDto);
    DepartmentDto map(Department department);
}
