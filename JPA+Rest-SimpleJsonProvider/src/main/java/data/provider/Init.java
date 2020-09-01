package data.provider;

import data.provider.model.Department;
import data.provider.model.Employee;
import data.provider.repository.DepartmentRepository;
import data.provider.repository.EmployeeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class Init {
    @Bean
    public ApplicationRunner initializer(EmployeeRepository employeeRepository,
                                         DepartmentRepository departmentRepository) {
        return args -> {
            departmentRepository.saveAll(
                    List.of("first","second","third","last").stream()
                            .map(x -> Department.builder().name(x).build())
                            .collect(Collectors.toList())
            );
            employeeRepository.save(Employee.builder()
                    .firstName("aaa")
                    .lastName("bbb")
                    .email("aaa@bbb.pl")
                    .address("Warsaw")
                    .department(Department.builder().id(1L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("xxx")
                    .lastName("yyy")
                    .email("xxx@yyy.pl")
                    .address("Cracow")
                    .department(Department.builder().id(3L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("zzz")
                    .lastName("qqq")
                    .email("zzz@qqq.pl")
                    .address("Lancut")
                    .department(Department.builder().id(2L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("iii")
                    .lastName("jjj")
                    .email("iii@jjj.pl")
                    .address("Lvov")
                    .department(Department.builder().id(3L).build())
                    .build());
        };
    }
}
