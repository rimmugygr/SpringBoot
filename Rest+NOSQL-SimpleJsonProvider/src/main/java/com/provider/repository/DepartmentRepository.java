package com.provider.repository;


import com.provider.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DepartmentRepository extends MongoRepository<Department,String> {
    Optional<Department> findDepartmentByName(String name);
}
