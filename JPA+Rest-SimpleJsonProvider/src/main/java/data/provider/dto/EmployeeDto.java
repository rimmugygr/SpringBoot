package data.provider.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String street;
    private Long departmentId;
    private Set<Long> taskIds;
}
