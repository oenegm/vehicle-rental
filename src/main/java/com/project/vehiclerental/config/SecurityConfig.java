package com.project.vehiclerental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userStore = new InMemoryUserDetailsManager();

        UserDetails u1 = User.withUsername("Jamal")
                .password("password")
                .authorities("read")
                .build();

        userStore.createUser(u1);

        return userStore;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
