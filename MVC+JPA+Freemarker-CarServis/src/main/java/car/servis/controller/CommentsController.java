package car.servis.controller;


import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/comment/")
public class CommentsController {

    @GetMapping("/**")
    public String test() {
        return "Mapowanie /comment  +  /**";
    }

    @GetMapping("/")
    public String home() {
        return "Mapowanie /comment + /* ";
    }

    @GetMapping("/{name:[a-z]+}{idComment:\\d+}")
    public String getVariable(@PathVariable(value = "name") String name, @PathVariable(value = "idComment") int id) {
        return "Mapowanie with redex  /comment + /{value}/{value} | Value of variable is " + name + " " + id;
    }

    @PostMapping("add")
    public String addComments(@RequestBody MultiValueMap<String, String> body) {
        return body.toString();
    }

    @RequestMapping(path = "/aaa", method = RequestMethod.GET, headers = "MyHeader=xxx")
    @ResponseBody
    public String getHeader() {
        return "Mapowanie /home + /aaa and send MyHeader = xxx by method GET";
    }

}
