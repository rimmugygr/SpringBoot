package data.provider.mapper;

import data.provider.dto.EmployeeDto;
import data.provider.model.Employee;
import data.provider.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "employee.department.id", target = "departmentId")
    @Mapping(target = "taskIds", source = "taskSet")
    EmployeeDto map(Employee employee);

    default Set<Long> map(Set<Task> taskSet) {
        return taskSet.stream().map(Task::getId).collect(Collectors.toSet());
    }

//    protected abstract List mapStringtoList(List childSource);
//
//    protected String mapChildSourceToString(ChildSource child) {
//        return child.getAction();
//    }
}
