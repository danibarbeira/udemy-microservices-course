package com.in28minutes.rest.webservice.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Ensure all http requests are authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // Enable Basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // WhiteList CSRF -> POST, PUT
        httpSecurity.csrf(
                c -> {
                    c.ignoringRequestMatchers("/users/*", "/posts/*");
                }
        );

        return httpSecurity.build();
    }

}
