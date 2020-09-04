package data.provider.mapper;

import data.provider.dto.TaskDto;
import data.provider.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task map(TaskDto taskDto);
    TaskDto map(Task task);


}
