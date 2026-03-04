package br.org.institutoacqua.gcc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {

        UserDetails admin = User
                .withUsername("admin")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails medico = User
                .withUsername("medico")
                .password(encoder.encode("123"))
                .roles("MEDICO")
                .build();

        UserDetails enfermagem = User
                .withUsername("enf")
                .password(encoder.encode("123"))
                .roles("ENFERMAGEM")
                .build();

        return new InMemoryUserDetailsManager(admin, medico, enfermagem);
    }
}