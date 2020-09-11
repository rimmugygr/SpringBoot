package com.provider.service;


import com.provider.model.Task;
import com.provider.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepo;

    public Task getTaskById(String id) {
        return taskRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public List<Task> addTasks(List<Task> tasks) {
        return taskRepo.saveAll(tasks);
    }
}
