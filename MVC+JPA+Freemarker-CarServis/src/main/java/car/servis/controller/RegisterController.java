package car.servis.controller;

import car.servis.model.AppUser;
import car.servis.model.Token;
import car.servis.repository.TokenRepo;
import car.servis.servis.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class RegisterController {
    private Logger logger= LoggerFactory.getLogger(RegisterController.class);

    private UserService userService;

    private TokenRepo tokenRepo;

    public RegisterController(UserService userService, TokenRepo tokenRepo) {
        this.userService = userService;
        this.tokenRepo = tokenRepo;
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
        userService.sendToken(appUser);
        return "register";
    }


    @GetMapping("/token")
    public String userActivation(@RequestParam String value){
        userService.userActivation(value);
        return "/login";
    }

}
