package car.servis.controller;

import car.servis.model.AppUser;
import car.servis.model.Token;
import car.servis.repository.TokenRepo;
import car.servis.servis.UserService;
import car.servis.validators.RegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class RegisterController {
    private Logger logger= LoggerFactory.getLogger(RegisterController.class);

    private UserService userService;
    private RegistrationValidator validate;

    public RegisterController(UserService userService, RegistrationValidator validate) {
        this.userService = userService;
        this.validate = validate;
    }

    @GetMapping("/registration")
    public String getRegister(Model model){
        model.addAttribute("user", new AppUser());
        return "registration";
    }

    @PostMapping("/registration")
    public String setRegister(@ModelAttribute("user")AppUser appUser, BindingResult bindingResult, Model model){
        validate.validate(appUser,bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            model.addAttribute("noErrors", true);
        }

        appUser.setRole("ROLE_USER");
        logger.info(appUser.toString());
        userService.addUser(appUser);
        //userService.sendToken(appUser);
        return "registration";
    }



    @GetMapping("/token")
    public String userActivation(@RequestParam String value){
        userService.userActivation(value);
        return "/login";
    }

}
