package boot.server;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyController {

    private static final String SECRET_KEY = "123";

    @GetMapping("/checkKey")
    public CheckKeyResult checkKey(@RequestParam(value = "key", defaultValue = "") String key){
        boolean isKeyCorrect = SECRET_KEY.equals(key);
        return new CheckKeyResult(isKeyCorrect);
    }
}
