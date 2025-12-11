package com.cart.problem.repo;

import com.cart.problem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUsername(String username);
}
