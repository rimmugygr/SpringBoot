package data.provider.service;

import data.provider.dto.TaskDto;
import data.provider.mapper.TaskMapper;
import data.provider.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepo;
    private final TaskMapper taskMapper;

    public TaskDto getTaskById(Long id) {
        return taskMapper.map(taskRepo.findById(id).orElseThrow(RuntimeException::new));
    }

    public Set<TaskDto> getAllTask() {
        return taskRepo.findAll().stream()
                .map(taskMapper::map)
                .collect(Collectors.toSet());
    }
}
