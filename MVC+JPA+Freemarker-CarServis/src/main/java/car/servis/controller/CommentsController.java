package car.servis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/comment")
public class CommentsController {

    @GetMapping("/**")
    public String test(){
        return "comments, nothing special";
    }

    @GetMapping("/")
    public String home(Locale locale){
        return locale.toString()+" in comment";
    }
}
