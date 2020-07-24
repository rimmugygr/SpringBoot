package my.safe.configure.security;

import my.safe.model.User;
import my.safe.model.UserV2;
import my.safe.repository.UserV2Repo;
import my.safe.repository.UserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class InitConfig {

    public InitConfig(UserRepo userRepo, UserV2Repo userV2Repo, PasswordEncoder passwordEncoder) {
        // for UserDetailService with model extends UserDetails
        User user = new User("user", passwordEncoder.encode("user"));
        user.grantAuthority("ROLE_USER");
        User admin = new User("admin", passwordEncoder.encode("admin"));
        admin.grantAuthority("ROLE_ADMIN");
        userRepo.save(user);
        userRepo.save(admin);

        // for UserRepositoryUserDetailsService
        UserV2 userV2 = new UserV2(UUID.randomUUID(),"user",passwordEncoder.encode("user"));
        userV2.grantAuthority("ROLE_USER");
        UserV2 adminV2 = new UserV2(UUID.randomUUID(),"admin",passwordEncoder.encode("admin"));
        adminV2.grantAuthority("ROLE_ADMIN");
        userV2Repo.save(userV2);
        userV2Repo.save(adminV2);
    }

}
