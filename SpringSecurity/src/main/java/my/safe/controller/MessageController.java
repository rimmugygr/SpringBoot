package my.safe.controller;

import my.safe.CurrentAuthorities;
import my.safe.CurrentUsername;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    @GetMapping("/public")
    public String getPublicMessage() {
        return "not secret, anybody knows this";
    }

    @GetMapping("/private")
    public String getPrivateMessage() {
        return "secret, now you knows this";
    }

    @GetMapping("/admin")
    public String getAdminMessage() {
        return "admin secret, only admins knows this";
    }

    @GetMapping("/menu")
    public String getMenu(@CurrentUsername String username, @CurrentAuthorities List<GrantedAuthority> authorities,
                          Authentication authentication) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            return "Hello " + authentication.getName() + " with " + authentication.getAuthorities().toString();
//        }
        return "Hello user " + username + " with authorities " +
                authorities.toString()
                        .replace("[", "")
                        .replace("]", "");
    }

}
