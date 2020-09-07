package com.provider.repository;

import com.provider.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task,String> {
}
