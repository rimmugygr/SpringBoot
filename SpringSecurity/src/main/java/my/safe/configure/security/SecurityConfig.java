package my.safe.configure.security;


import my.safe.repository.UserRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;


@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepo userRepo;

    public SecurityConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Bean
//    @Primary
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource) {
//            @Override
//            protected List<GrantedAuthority> loadUserAuthorities(String username) {
//                return AuthorityUtils.createAuthorityList("ROLE_USER");
//            }
        };
    }

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepo.getOneByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/api/public").permitAll()
                .mvcMatchers("/api/private").authenticated()
                .mvcMatchers("/api/admin").hasRole("ADMIN")
                .mvcMatchers("/api/menu").authenticated()
                .and()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/api/info").permitAll()
                .mvcMatchers(HttpMethod.POST, "/api/info").hasAnyRole("ADMIN","USER")
                .mvcMatchers(HttpMethod.DELETE, "/api/info").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/api/menu").permitAll()
                .and()
                .logout().logoutUrl("/api/logout").permitAll()
                .and()
                .csrf().disable()
                .httpBasic();

    }
}
