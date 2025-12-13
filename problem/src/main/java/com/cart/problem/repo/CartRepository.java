package com.cart.problem.repo;

import com.cart.problem.models.Cart;
import com.cart.problem.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByUser(UserInfo user);
}
