package gradle.reactiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInit {
    private BoardMessageRepository boardMessageRepository;

    @Autowired
    public SpringInit(BoardMessageRepository boardMessageRepository) {
        this.boardMessageRepository = boardMessageRepository;
    }
}
