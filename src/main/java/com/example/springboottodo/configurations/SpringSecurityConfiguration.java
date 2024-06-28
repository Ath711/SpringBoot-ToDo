package com.example.springboottodo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        User userDetails = createNewUser("root", "root");
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
       
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .build();
    }

    private User createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        return (User) User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }


}
