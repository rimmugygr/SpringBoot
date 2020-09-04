package data.provider.controller;

import data.provider.dto.TaskDto;
import data.provider.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public TaskDto getAllEmployee(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public Set<TaskDto> getAllEmployee() {
        return taskService.getAllTask();
    }
}
