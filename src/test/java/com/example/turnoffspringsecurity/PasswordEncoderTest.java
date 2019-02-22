package com.example.turnoffspringsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class PasswordEncoderTest {

    @TestConfiguration
    static class PasswordEncoderConfiguration {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void when_PasswordEncoderInjected() {
        // given
        String userPassword = "1234";

        // when
        String encodedPassword = passwordEncoder.encode(userPassword);

        // then
        assertThat(encodedPassword).contains("{bcrypt}");
    }
}
