package com.example.demo.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private ObjectMapper objectMapper;

//  HttpSecurity będzie dostępne wraz z zaleznością Spring Security
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // TODO 2b
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .antMatchers("/contact").permitAll()
//                        .anyRequest().authenticated()
//                );
        // TODO 3

//                .httpBasic(httpBasic -> {
//                    httpBasic.authenticationEntryPoint((request, response, authException) -> {
        // TODO 3a

//                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // TODO 3b

//                        response.addHeader("WWW-Authenticate", "Basic");
        // TODO 3c

//                        response.getWriter().println(objectMapper.writeValueAsString(Map.of("message", "unauthenticated")));
//                });
//        return http.build();
//    }



}