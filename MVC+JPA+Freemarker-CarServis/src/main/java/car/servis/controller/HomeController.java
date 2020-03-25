package car.servis.controller;

import car.servis.model.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class HomeController {
    private Logger  logger= LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/","/home","/index"})
    public String home(Model model, HttpServletRequest request){
        // add to model user name
        model.addAttribute("user", request.getRemoteUser());

        // get user roles
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        //add to model user roles
        model.addAttribute("authorities", authorities);

        // full info about logged user to console
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

//    @GetMapping("/myLogin-error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }
}
