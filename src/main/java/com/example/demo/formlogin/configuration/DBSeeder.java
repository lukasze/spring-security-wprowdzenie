package com.example.demo.formlogin.configuration;

import com.example.demo.formlogin.model.User;
import com.example.demo.formlogin.model.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DBSeeder implements ApplicationRunner {


    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public DBSeeder(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        // Podejrzyj, jak hasło wygląda w bazie
        String janPasswordBcrypted = passwordEncoder.encode("kowalski");
        String adamPasswordBcrypted = passwordEncoder.encode("nowak");
        userRepository.save(new User(1L,"jan", janPasswordBcrypted, List.of("ROLE_USER")));
        userRepository.save(new User(2L, "adam", adamPasswordBcrypted, List.of("ROLE_ADMIN")));
    }
}
