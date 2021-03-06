package com.provider.controller;


import com.provider.model.Task;
import com.provider.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/list")
    public List<Task> postTasks(@RequestBody List<Task> tasks) {
        return taskService.addTasks(tasks);
    }
}
