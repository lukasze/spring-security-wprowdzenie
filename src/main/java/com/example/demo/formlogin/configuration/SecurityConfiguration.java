package com.example.demo.formlogin.configuration;

import com.example.demo.formlogin.model.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    public SecurityConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Użytkownicy z bazy
        auth.userDetailsService(userDetailsService())
        // Użycie Bcrypt (Zobacz użycie PasswordEncoder w DB seeder i jak wygląda hasło w bazie )
                .passwordEncoder(passwordEncoder());
    }

    protected UserDetailsService userDetailsService() {
        return username -> {
            com.example.demo.formlogin.model.User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException(""));
            return new User(user.getUsername(), user.getPassword(), user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Przepuszczenie nieautoryzowanych żądań do /login i /h2-console
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .antMatchers("/login").permitAll()
                            .antMatchers("/h2-console/**").permitAll()
                            .anyRequest()
                            .authenticated();
                })
                // Własna strona do logwania (endpoint /login przekierowuje na login.html)
                .formLogin(formLogin -> {
                    formLogin
                            .loginPage("/login")
                            .loginProcessingUrl("/doLogin")
                            .usernameParameter("user")
                            .passwordParameter("pass");
                })
                /*
                    Domyślny mechanizm wylogowania, zachowanie
                    https://docs.spring.io/spring-security/reference/servlet/authentication/logout.html


                    Otwórz konsolę developerską w Chrome, zaloguj się (zaznacz remember me).
                    Zobacz ciasteczka w Application -> Cookies
                    Wyloguj się - zaboserwuj zmianę w Cookies
                 */
                .logout()
                .and()
                // Wyłączenie domyślnych zabezpieczeń - dla konsoli h2
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                // ekstra ciasteczko
                .rememberMe(rememberMe -> {
                    rememberMe
                            .key("some-key")
                            .rememberMeCookieName("rememberMe")
                            .rememberMeParameter("rememberMe");
                });
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
