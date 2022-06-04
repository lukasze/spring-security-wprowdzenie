package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @GetMapping
    public Map<String, Object> index() {
        // TODO 4a zamień wartość mapy na: SecurityContextHolder.getContext().getAuthentication().getName()
        return Map.of("Welcome",SecurityContextHolder.getContext().getAuthentication().getName());
    }
        // TODO 2a
    @GetMapping("/contact")
    public Map<String, Object> contact() {
        return Map.of("email", "contact@example.com", "phone", "+48 333 888 222");
    }
}