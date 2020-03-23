package server.message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.message.model.SecretMessage;

@RestController
public class MessageController {

    private static final String SECRET_MESSAGE = "Tajan wiadomość na głownym serverze";

    @GetMapping("/getMessage")
    public SecretMessage getMessage(){

        return new SecretMessage(SECRET_MESSAGE);
    }
}
