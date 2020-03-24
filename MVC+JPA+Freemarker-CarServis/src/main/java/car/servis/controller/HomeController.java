package car.servis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping({"/","/home","/index"})
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("user", request.getRemoteUser());
        return "index";
    }

}
