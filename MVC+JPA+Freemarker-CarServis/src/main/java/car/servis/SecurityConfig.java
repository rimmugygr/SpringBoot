package car.servis;

import car.servis.servis.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    //login with out db
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("aaa").password("{noop}12345").roles("USER").build());
//        manager.createUser(User.withUsername("admin").password("{noop}admin").roles("ADMIN").build());
//        manager.createUser(User.withUsername("bbb").password("{noop}bbb").roles("USER").build());
//        return manager;
//    }

    //password encoder
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserDetailsServiceImpl userDetailsService;

    //inject bean
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //login with db
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/user","/comment/**","/cookie/**", "/file/**","/param/**", "/issue/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/index")
                .loginPage("/myLogin").permitAll()
//                .failureUrl("/myLogin-error").permitAll()
                .loginProcessingUrl("/myLogin").permitAll()
                .passwordParameter("pass")
                .usernameParameter("name");
//                .and()
//                .httpBasic();

    }
}
