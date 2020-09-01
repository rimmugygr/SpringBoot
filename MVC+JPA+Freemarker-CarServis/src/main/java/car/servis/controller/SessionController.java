package car.servis.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class SessionController {

    @GetMapping("/")
    public String setLogin(@RequestParam("login") String login, HttpServletRequest request) {
        request.getSession().setAttribute("login", login);
        return "new login in session :" + login;
    }

    @GetMapping("/logged")
    public String getLogin(@SessionAttribute("login") String login) {
        return "logged in session :" + login;
    }
}
