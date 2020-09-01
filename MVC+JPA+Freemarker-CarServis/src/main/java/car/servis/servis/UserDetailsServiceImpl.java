package car.servis.servis;

import car.servis.model.AppUser;
import car.servis.repository.AppUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * communication spring security with db
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger("Logged");

    private AppUserRepo appUserRepo;

    //bean has automatic inject by @autowired
    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // todo on optional trow in case if not exist that username in db
        AppUser appUser = appUserRepo.findByUsername(s);
        logger.info(appUser.getUsername());
        return new User(appUser.getUsername(), appUser.getPassword(), appUser.getAuthorities());
    }

}
