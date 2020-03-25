package car.servis.controller;

import car.servis.dto.AppUser;
import car.servis.servis.UserDetailsServiceImpl;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    private Logger  logger= LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/","/home","/index"})
    public String home(Model model, HttpServletRequest request){
        model.addAttribute("user", request.getRemoteUser());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String login;
        if (principal instanceof UserDetails){
            login=((UserDetails) principal).getUsername();
            logger.info("Logged user:"+login);
        }
        if (principal instanceof AppUser){
            logger.info(((AppUser) principal).toString());
        }

        return "index";
    }

    @GetMapping("/myLogin")
    public String login(){
        return "login";
    }
}
