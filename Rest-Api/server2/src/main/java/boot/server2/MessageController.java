package boot.server2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final String SECRET_MESSAGE = "Tajan wiadomość na głownym serverze";

    @GetMapping("/getMessage")
    public SecretMessage getMessage(){

        return new SecretMessage(SECRET_MESSAGE);
    }
}
