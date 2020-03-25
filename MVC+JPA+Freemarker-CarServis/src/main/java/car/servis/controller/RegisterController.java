package car.servis.controller;

import car.servis.dto.AppUser;
import car.servis.servis.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private Logger logger= LoggerFactory.getLogger(RegisterController.class);

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String setRegister(AppUser appUser){
        logger.info(appUser.toString());
        userService.addUser(appUser);
        return "register";
    }
}
