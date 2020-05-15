package gradle.reactiv;

import org.springframework.data.repository.CrudRepository;

public interface BoardMessageRepository extends CrudRepository<BoardMessage, String> {
}
