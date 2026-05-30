package com.galaxy.store.nexus_galaxy_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// Why @Bean ??
// Spring creates object globally
// Can injection dependency anywhere
// @Autowired
// private PasswordEncoder passwordEncoder; 