package com.jwt.practice.JWT.Practice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.practice.JWT.Practice.model.User;

// STEP : 3 - Create User & Role Repository

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
}
