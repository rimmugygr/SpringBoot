package com.provider;


import com.provider.model.Department;
import com.provider.model.Employee;
import com.provider.model.Task;
import com.provider.repository.DepartmentRepository;
import com.provider.repository.EmployeeRepository;
import com.provider.repository.TaskRepository;
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
//            List<Department> departments = List.of("first", "second", "third", "last").stream()
//                    .map(x -> Department.builder().name(x).build())
//                    .peek(departmentRepository::save)
//                    .collect(Collectors.toList());
//
//            List<Task> tasks = List.of(
//                    Task.builder().title("medium job").progress(13L).status("inactive").build(),
//                    Task.builder().title("hard job").progress(10L).status("active").build(),
//                    Task.builder().title("easy job").progress(33L).status("active").build(),
//                    Task.builder().title("very hard job").progress(70L).status("active").build(),
//                    Task.builder().title("medium job").progress(13L).status("active").build(),
//                    Task.builder().title("very easy job").progress(0L).status("inactive").build());
//            taskRepository.saveAll(tasks);
//
//            employeeRepository.save(Employee.builder()
//                    .firstName("aaa")
//                    .lastName("bbb")
//                    .email("aaa@bbb.pl")
//                    .city("Warsaw")
//                    .street("Long 22")
//                    .departmentId(departments.get(0).getId())
//                    .taskIds(Set.of(tasks.get(0).getId(),tasks.get(1).getId()))
//                    .build());
//
//            employeeRepository.save(Employee.builder()
//                    .firstName("xxx")
//                    .lastName("yyy")
//                    .email("xxx@yyy.pl")
//                    .city("Cracow")
//                    .street("Center 1 b")
//                    .departmentId(departments.get(2).getId())
//                    .taskIds(Set.of(tasks.get(2).getId(),tasks.get(3).getId()))
//                    .build());
//            employeeRepository.save(Employee.builder()
//                    .firstName("zzz")
//                    .lastName("qqq")
//                    .email("zzz@qqq.pl")
//                    .city("Lancut")
//                    .street("Short 71 d")
//                    .departmentId(departments.get(1).getId())
//                    .taskIds(Set.of(tasks.get(3).getId()))
//                    .build());
//            employeeRepository.save(Employee.builder()
//                    .firstName("iii")
//                    .lastName("jjj")
//                    .email("iii@jjj.pl")
//                    .city("Lvov")
//                    .street("Main 11/3 b")
//                    .departmentId(departments.get(1).getId())
//                    .taskIds(Set.of(tasks.get(4).getId(),tasks.get(5).getId()))
//                    .build());

        };
    }
}
