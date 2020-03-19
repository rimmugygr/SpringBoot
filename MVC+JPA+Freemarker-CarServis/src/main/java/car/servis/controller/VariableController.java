package car.servis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class VariableController {


    @GetMapping(path = {"/param/{idVariable}/{idText}","/param/{idVariable}"})
    public String getVariable(@PathVariable(value = "idVariable") String variable , @PathVariable(value = "idText") Optional<String> text){
        return "Mapowanie /param + /{value}/{value} | Value of variable is " + variable + " " + text.orElse("empty");
    }

    @GetMapping(path = {"/argsmap/{idVariable}/{idText}","/argsmap/{idVariable}"})
    public String getVariable(@PathVariable Map<String,String> argsMap){
        return "Mapowanie /param + /{value}/{value} | Map:" + argsMap.toString();
    }

}
