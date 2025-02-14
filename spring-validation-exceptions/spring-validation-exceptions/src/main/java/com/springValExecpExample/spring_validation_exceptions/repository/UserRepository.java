package com.springValExecpExample.spring_validation_exceptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springValExecpExample.spring_validation_exceptions.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
