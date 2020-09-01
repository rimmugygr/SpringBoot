package data.provider.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Long departmentId;
}
