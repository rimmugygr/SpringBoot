package data.provider.dto;

import data.provider.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long progress;
}
