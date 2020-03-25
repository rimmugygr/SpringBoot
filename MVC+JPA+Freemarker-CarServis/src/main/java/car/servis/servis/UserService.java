package car.servis.servis;

import car.servis.dto.AppUser;
import car.servis.repository.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // communication with db
    private AppUserRepo appUserRepo;
    // encode password
    private PasswordEncoder passwordEncoder;
    //inject bean
    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }
    // add new user to data base
    public void addUser(AppUser appUser) {
        //we got not encode password , we encode this with PasswordEncoder
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        // write to db new user
        appUserRepo.save(appUser);
    }

    // for test
    public List<AppUser> getAllUser() {
        List<AppUser> result = appUserRepo.findAll();
        return result;
    }
}
