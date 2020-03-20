package car.servis.servis;

import car.servis.dto.Issue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IssuesService {
    String getIssue();
    List<Issue>  listIssues();
}
