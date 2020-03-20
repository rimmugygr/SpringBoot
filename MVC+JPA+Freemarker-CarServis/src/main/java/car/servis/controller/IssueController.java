package car.servis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/{idVariable}")
    public String home(@PathVariable(name = "idVariable") String idVariable , Model model){
        model.addAttribute("idVariable", idVariable);
        return "home";
    }

}
