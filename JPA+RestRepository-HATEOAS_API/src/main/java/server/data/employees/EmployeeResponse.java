package server.data.employees;

import org.springframework.data.rest.core.config.Projection;
import server.data.department.Department;

@Projection(name = "employeeResponse", types = { Employee.class })
public interface EmployeeResponse {
    String getFirstName();
    String getLastName();
    String getMail();
    Department getDepartment();
}
