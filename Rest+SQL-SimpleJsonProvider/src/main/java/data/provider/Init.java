package data.provider;

import data.provider.model.Department;
import data.provider.model.Employee;
import data.provider.model.Task;
import data.provider.repository.DepartmentRepository;
import data.provider.repository.EmployeeRepository;
import data.provider.repository.TaskRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class Init {
    @Bean
    public ApplicationRunner initializer(EmployeeRepository employeeRepository,
                                         DepartmentRepository departmentRepository,
                                         TaskRepository taskRepository) {
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
                    .city("Warsaw")
                    .street("Long 22")
                    .department(Department.builder().id(1L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("xxx")
                    .lastName("yyy")
                    .email("xxx@yyy.pl")
                    .city("Cracow")
                    .street("Center 1 b")
                    .department(Department.builder().id(3L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("zzz")
                    .lastName("qqq")
                    .email("zzz@qqq.pl")
                    .city("Lancut")
                    .street("Short 71 d")
                    .department(Department.builder().id(2L).build())
                    .build());
            employeeRepository.save(Employee.builder()
                    .firstName("iii")
                    .lastName("jjj")
                    .email("iii@jjj.pl")
                    .city("Lvov")
                    .street("Main 11/3 b")
                    .department(Department.builder().id(3L).build())
                    .build());
            taskRepository.saveAll(Set.of(
                    Task.builder().title("medium job").progress(13L).status("inactive").employee(Employee.builder().id(1L).build()).build(),
                    Task.builder().title("hard job").progress(10L).status("active").employee(Employee.builder().id(1L).build()).build(),
                    Task.builder().title("easy job").progress(33L).status("active").employee(Employee.builder().id(4L).build()).build(),
                    Task.builder().title("very hard job").progress(70L).status("active").employee(Employee.builder().id(3L).build()).build(),
                    Task.builder().title("medium job").progress(13L).status("active").employee(Employee.builder().id(2L).build()).build(),
                    Task.builder().title("very easy job").progress(0L).status("inactive").employee(Employee.builder().id(2L).build()).build()
                    ));
        };
    }
}
