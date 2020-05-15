package gradle.reactiv.repository;

import gradle.reactiv.model.BoardMessage;
import org.springframework.data.repository.CrudRepository;

public interface BoardMessageRepository extends CrudRepository<BoardMessage, String> {
}
