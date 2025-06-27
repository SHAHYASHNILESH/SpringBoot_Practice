package com.tender.management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.management.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
	Optional<RoleModel> findByRoleName(String roleName);
}
