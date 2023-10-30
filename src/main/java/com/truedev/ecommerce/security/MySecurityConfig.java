package com.truedev.ecommerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/produtos").permitAll()
            .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
            .requestMatchers(HttpMethod.POST, "/login").permitAll()
            .requestMatchers(HttpMethod.GET, "/pedidos").permitAll()
            .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
            .anyRequest().authenticated().and().cors();

    http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
