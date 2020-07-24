package my.safe.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class UserV2Authority {
    @Id
    private String authority;
    @ManyToOne
    UserV2 user;


    public UserV2Authority() {
    }

    public UserV2Authority(String authority, UserV2 user) {
        this.authority = authority;
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public UserV2 getUser() {
        return user;
    }

    public void setUser(UserV2 user) {
        this.user = user;
    }
}
