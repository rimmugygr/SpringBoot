package my.safe.services;

import my.safe.model.User;
import my.safe.model.UserV2;
import my.safe.repository.UserV2Repo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserV2RepoUserDetailServices implements UserDetailsService {
    private final UserV2Repo userV2Repo;

    public UserV2RepoUserDetailServices(UserV2Repo userV2Repo) {
        this.userV2Repo = userV2Repo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userV2Repo.getOneByUsername(s)
                .map(BridgeUserV2::new)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }

    private static class BridgeUserV2 extends UserV2 implements UserDetails {
        public BridgeUserV2() {
        }

        public BridgeUserV2(UUID id, String username, String password) {
            super(id, username, password);
        }

        public BridgeUserV2(UserV2 user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.getUserAuthorities().stream()
                    .map(a -> new SimpleGrantedAuthority(a.getAuthority()))
                    .collect(Collectors.toList());
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
