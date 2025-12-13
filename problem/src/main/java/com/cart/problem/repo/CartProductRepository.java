package com.cart.problem.repo;

import com.cart.problem.models.Cart;
import com.cart.problem.models.CartProduct;
import com.cart.problem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    Optional<CartProduct> findByCartAndProduct(Cart cart, Product product);

    Optional<CartProduct> findByProduct(Product product);
}
