package client.application.controller;

import client.application.model.CheckKeyResult;
import client.application.model.KeyModel;
import client.application.model.SecretMessage;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SafeController {

    private static final String KEY_FROM_MODEL_ATTR_NAME = "keyModel";
    private static final String SAFE_OPENED_ATTR_NAME = "isSafeOpened";
    private static final String MESSAGE_ATTR_NAME = "message";

    @GetMapping("/safe")
    public String safeGet(Model model, Authentication authentication) {
        String userName = authentication.getName();
        String roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        model.addAttribute(KEY_FROM_MODEL_ATTR_NAME, new KeyModel());
        model.addAttribute("user", userName);
        model.addAttribute("roles", roles);
        return "safe";
    }

    @PostMapping("/safe")
    public String safePost(@ModelAttribute(KEY_FROM_MODEL_ATTR_NAME) KeyModel keyModel, Model model) {
        boolean keyCorrect = isKeyCorrect(keyModel);
        model.addAttribute(SAFE_OPENED_ATTR_NAME, keyCorrect);

        if (keyCorrect) {
            String message = fetchSecretMessage();
            model.addAttribute(MESSAGE_ATTR_NAME, message);
        } else {
            model.addAttribute(MESSAGE_ATTR_NAME, "");
        }


        return "safe";
    }

    public boolean isKeyCorrect(KeyModel keyModel) {
        String userKey = keyModel.getKey();
        RestTemplate restTemplate = new RestTemplate();
        CheckKeyResult result = restTemplate.getForObject("http://localhost:8081/checkKey?key={key}",
                CheckKeyResult.class, Collections.singletonMap("key", userKey));
        return result.isCorrect();
    }

    public String fetchSecretMessage() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new BasicAuthenticationInterceptor("admin", "admin"));
        SecretMessage message = restTemplate.getForObject(
                "http://localhost:8083/getMessage", SecretMessage.class);
        return message.getText();
    }
}
