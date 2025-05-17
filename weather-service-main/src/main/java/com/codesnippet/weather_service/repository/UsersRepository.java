package com.codesnippet.weather_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesnippet.weather_service.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	Optional<Users>findByUsername(String username);

}
