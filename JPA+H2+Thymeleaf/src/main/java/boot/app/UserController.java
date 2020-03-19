package boot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public Iterable<User> getUser(){

        User user0 = new User();
        user0.setEmail("aaa@bbb.pl");
        user0.setName("aaa");
        User user1 = new User();
        user1.setEmail("ccc@ddd.pl");
        user1.setName("ccc");
        User user2 = new User();
        user2.setEmail("xxx@yyy.pl");
        user2.setName("xyxy");

        userRepository.save(user0);
        userRepository.save(user1);
        userRepository.save(user2);

        return userRepository.findAll();
    }
}
