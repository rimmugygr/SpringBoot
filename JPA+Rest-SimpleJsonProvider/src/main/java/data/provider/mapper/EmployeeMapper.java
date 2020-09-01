package data.provider.mapper;

import data.provider.dto.EmployeeDto;
import data.provider.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "employee.department.id", target = "departmentId")
    EmployeeDto map(Employee employee);
    @Mapping(source = "employeeDto.departmentId", target = "department.id")
    Employee map(EmployeeDto employeeDto);
}
