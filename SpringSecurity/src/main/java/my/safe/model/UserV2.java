package my.safe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
public class UserV2 {
    @Id
    private UUID id;
    @Column(name = "username", unique = true)
    private String username;
    private String password;
    private Boolean enabled = true;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<UserV2Authority> userAuthorities = new ArrayList<>();


    public UserV2() {
    }

    public UserV2(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserV2(UserV2 user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.userAuthorities = user.userAuthorities;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<UserV2Authority> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(Collection<UserV2Authority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public void grantAuthority(String authority) {
        this.userAuthorities.add(new UserV2Authority(authority,this));
    }
}
