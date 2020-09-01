package car.servis.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    @GetMapping("/cookie/")
    public String getCookie(@RequestParam(name = "newCooki", required = false) String newCookie,
                            @CookieValue(name = "myCookie", required = false, defaultValue = "small") String cookie,
                            HttpServletResponse response) {
        if (newCookie != null) {
            response.addCookie(new Cookie("myCookie", newCookie));
            return "Set cooki to: " + newCookie;
        } else {
            return "Cooki value is: " + cookie;
        }

    }
}
