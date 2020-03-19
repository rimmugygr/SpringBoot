package car.servis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class IssueController {

    @GetMapping("/**")
    @ResponseBody
    public String test(){
        return "something, nothing special";
    }

    @RequestMapping(path = "/aaa" , method = RequestMethod.GET , headers = "MyHeader=xxx")
    @ResponseBody
    public String getHeader(){
        return "You send MyHeader = xxx by method GET";
    }

    @GetMapping("/")
    @ResponseBody
    public String home(Locale locale){
        return locale.toString();
    }
}
