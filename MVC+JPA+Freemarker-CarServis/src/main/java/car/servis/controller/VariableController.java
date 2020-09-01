package car.servis.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class VariableController {


    @GetMapping(path = {"/param/{idVariable}/{idText}", "/param/{idVariable}"})
    public String getVariable(@PathVariable(value = "idVariable") String variable, @PathVariable(value = "idText") Optional<String> text) {
        return "Mapowanie /param/{value}/{value} | Value of variable is " + variable + " " + text.orElse("empty");
    }

    @GetMapping(path = {"/argsmap/{idVariable}/{idText}", "/argsmap/{idVariable}"})
    public String getVariable(@PathVariable Map<String, String> argsMap) {
        return "Mapowanie /param/{value}/{value} | Map:" + argsMap.toString();
    }

    @GetMapping("/variable/")
    public String getVariable(@RequestParam(name = "number", required = true) int number, @RequestParam(name = "text", defaultValue = "defaultText", required = false) String text) {
        return "Mapowanie /variable | Value of variable is : " + number + " " + text;
    }

    @GetMapping("/header")
    public String getHeader(@RequestHeader("User-Agent") String userAgent) {
        return "Mapowanie /header | Value of user agent in header : " + userAgent;
    }

    @GetMapping("/headerMap")
    public String getHeader(@RequestHeader Map<String, String> headMap) {
        return "Mapowanie /header | Map of header : " + headMap.toString();
    }

}
