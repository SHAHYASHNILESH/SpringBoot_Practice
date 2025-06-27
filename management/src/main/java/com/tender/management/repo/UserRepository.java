package com.tender.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.management.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	Optional<UserModel> findByEmail(String email);
}
