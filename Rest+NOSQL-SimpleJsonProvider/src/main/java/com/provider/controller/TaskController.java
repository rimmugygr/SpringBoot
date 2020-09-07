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
    public Task getAllEmployee(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<Task> getAllEmployee() {
        return taskService.getAllTask();
    }
}
