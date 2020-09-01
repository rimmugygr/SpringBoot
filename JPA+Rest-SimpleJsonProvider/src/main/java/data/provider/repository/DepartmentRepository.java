package data.provider.repository;


import data.provider.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
