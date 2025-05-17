package com.codesnippet.weather_service.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codesnippet.weather_service.entity.Users;
import com.codesnippet.weather_service.repository.UsersRepository;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234")); // Securely store password
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
        };
    }
}
