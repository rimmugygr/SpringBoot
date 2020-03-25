package car.servis.servis;

import car.servis.model.AppUser;
import car.servis.model.Token;
import car.servis.repository.AppUserRepo;
import car.servis.repository.TokenRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private MailService mailService;
    // users db
    private AppUserRepo appUserRepo;
    // encoder for password
    private PasswordEncoder passwordEncoder;
    // token db
    private TokenRepo tokenRepo;

    //inject bean
    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo, MailService mailService) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
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

    public void sendToken(AppUser appUser) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setAppUser(appUser);
        tokenRepo.save(token);

        String url = "http://localhost:/token?value="+tokenValue;
        try {
            mailService.sendMail(appUser.getMail(),"Verification link", url,false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void userActivation(String value) {
        Token tokenByValue = tokenRepo.findByValue(value);
        AppUser appUser = tokenByValue.getAppUser();
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
    }
}
