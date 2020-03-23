package server.message.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import server.message.model.SecretMessage;

import java.util.stream.Collectors;

@RestController
public class MessageController {

    private static final String SECRET_MESSAGE = "Tajan wiadomość na głownym serverze wrrrr";

    @GetMapping("/getMessage")
    public SecretMessage getMessage(){
        return new SecretMessage(SECRET_MESSAGE);
    }
}
