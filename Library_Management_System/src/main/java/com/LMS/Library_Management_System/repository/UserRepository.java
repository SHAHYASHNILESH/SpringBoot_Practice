package com.LMS.Library_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LMS.Library_Management_System.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
