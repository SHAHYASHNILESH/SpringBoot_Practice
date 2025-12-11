package com.cart.problem.dto;

import com.cart.problem.models.UserInfo;
import com.cart.problem.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsersAndRoles(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            // ----------------------------------
            // 1. Insert Users
            // ----------------------------------
            UserInfo u1 = new UserInfo(
                    null,
                    "jack",
                    passwordEncoder.encode("pass_word"),
                    "CONSUMER"
            );

            UserInfo u2 = new UserInfo(
                    null,
                    "bob",
                    passwordEncoder.encode("pass_word"),
                    "CONSUMER"
            );

            UserInfo u3 = new UserInfo(
                    null,
                    "apple",
                    passwordEncoder.encode("pass_word"),
                    "SELLER"
            );

            UserInfo u4 = new UserInfo(
                    null,
                    "glaxo",
                    passwordEncoder.encode("pass_word"),
                    "SELLER"
            );

            userRepository.save(u1);
            userRepository.save(u2);
            userRepository.save(u3);
            userRepository.save(u4);

            System.out.println("✅ Default Users & Roles inserted successfully.");
        };
    }
}

