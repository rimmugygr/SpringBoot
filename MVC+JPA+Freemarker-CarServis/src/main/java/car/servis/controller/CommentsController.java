package car.servis.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Optional;
@RestController
@RequestMapping("/comment/")
public class CommentsController {

    @GetMapping("/**")
    public String test(){
        return "Mapowanie /comment  +  /**";
    }

    @GetMapping("/")
    public String home(){
        return "Mapowanie /comment + /* ";
    }

    @GetMapping("/{name:[a-z]+}{idComment:\\d+}")
    public String getVariable(@PathVariable(value = "name") String name , @PathVariable(value = "idComment") int id){
        return "Mapowanie with redex  /comment + /{value}/{value} | Value of variable is " + name + " " + id;
    }
}
