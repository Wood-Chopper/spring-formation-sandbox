package com.example.clientapp.security.config;

import com.example.clientapp.security.properties.ApplicationUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ConditionalOnWebApplication
@EnableConfigurationProperties(ApplicationUsers.class)
@RequiredArgsConstructor
@Slf4j
public class SecurityConfiguration {

    private final ApplicationUsers application;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(r -> r.anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        application.getUsers().forEach(client -> {
            manager.createUser(User.withDefaultPasswordEncoder()
                    .username(client.getUsername())
                    .password(client.getPassword())
                    .authorities(client.getAuthorities())
                    .build());
            log.info("Imported client {}", client);
        });

        return manager;
    }
}
