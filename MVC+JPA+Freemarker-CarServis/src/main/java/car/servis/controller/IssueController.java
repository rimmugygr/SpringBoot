package car.servis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping("/home")
public class IssueController {

    @GetMapping("/**")
    @ResponseBody
    public String test(){
        return "Mapowanie /home + /**";
    }

    @RequestMapping(path = "/aaa" , method = RequestMethod.GET , headers = "MyHeader=xxx")
    @ResponseBody
    public String getHeader(){
        return "Mapowanie /home + /aaa and send MyHeader = xxx by method GET";
    }

    @GetMapping("/")
    @ResponseBody
    public String home(Locale locale){
        return "Mapowanie /home + / "+locale.toString();
    }
}
