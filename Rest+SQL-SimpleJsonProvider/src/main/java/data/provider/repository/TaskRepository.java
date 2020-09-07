package data.provider.repository;

import data.provider.model.Employee;
import data.provider.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


public interface TaskRepository extends JpaRepository<Task,Long> {

    Set<Task> findAllByEmployeeId(Long employeeId);
}
