package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails manager = User.builder()
                .username("manager")
                .password(encoder.encode("manager123"))
                .roles("MANAGER")
                .build();

        UserDetails hr = User.builder()
                .username("hr")
                .password(encoder.encode("hr123"))
                .roles("HR")
                .build();

        UserDetails employee = User.builder()
                .username("employee")
                .password(encoder.encode("emp123"))
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(admin, manager, hr, employee);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
