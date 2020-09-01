package server.data.employees;

import lombok.Data;
import server.data.department.Department;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    @ManyToOne
    private Department department;

}
