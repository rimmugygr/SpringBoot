package car.servis;

import car.servis.dto.AppUser;
import car.servis.repository.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {


    public Start(AppUserRepo appUserRepo , PasswordEncoder passwordEncoder) {

        AppUser andrzej = new AppUser();
        andrzej.setUsername("andrzej");
        andrzej.setPassword(passwordEncoder.encode("andrzej123"));
        andrzej.setRole("ROLE_ADMIN");

        AppUser marek = new AppUser();
        marek.setUsername("marek");
        marek.setPassword(passwordEncoder.encode("marek123"));
        marek.setRole("ROLE_USER");

        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole("ROLE_ADMIN");

        appUserRepo.save(andrzej);
        appUserRepo.save(marek);
        appUserRepo.save(admin);
    }
}
