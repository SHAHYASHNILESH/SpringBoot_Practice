package com.tender_management.tender_management_system.repository;

import com.tender_management.tender_management_system.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByEmail(String username);
}
