package com.jwt.practice.JWT.Practice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.practice.JWT.Practice.model.Role;

//STEP : 3 - Create User & Role Repository

public interface RoleRepository extends JpaRepository<Role, Long> {

}
