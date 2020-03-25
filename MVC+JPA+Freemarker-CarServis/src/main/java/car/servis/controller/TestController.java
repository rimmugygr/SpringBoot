package car.servis.controller;

import car.servis.model.AppUser;
import car.servis.servis.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test(){
        String result="";
        for (AppUser appUser : userService.getAllUser()) {
            result+= appUser.toString()+"</br>";
        }
        return result;
    }
}
