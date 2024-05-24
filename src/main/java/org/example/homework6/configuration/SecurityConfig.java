package org.example.homework6.configuration;

import org.example.homework6.user.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(c -> c
                        .requestMatchers("/public/**")
                        .permitAll()
                        .requestMatchers("/support/**")
                        .hasAuthority(UserRole.ROLE_SUPPORT.name())
                        .requestMatchers("/admin/**")
                        .hasAuthority(UserRole.ROLE_ADMIN.name())
                ).httpBasic(
                        httpBasicConfigurer -> {
                        }
                ).build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("user"))
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails support = User.withUsername("support")
                .password(passwordEncoder().encode("support"))
                .roles("SUPPORT")
                .build();
        return new InMemoryUserDetailsManager(user, admin, support);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
