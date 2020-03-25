package car.servis.controller;

import car.servis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user")
    public String formGet(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/user")
    public String formPost(@Valid User user, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
        }
        model.addAttribute("user", user);
        return "form";
    }
}
