package com.example.turnoffspringsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TurnoffSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurnoffSpringsecurityApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/encode/{password}")
    public String getEncodedPassword(@PathVariable("password") String password) {
        return "Input: " + password + ", Output: " + passwordEncoder.encode(password);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
