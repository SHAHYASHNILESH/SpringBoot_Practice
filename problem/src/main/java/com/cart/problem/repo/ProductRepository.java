package com.cart.problem.repo;

import com.cart.problem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductName(String s);

    List<Product> findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(@Param("keyword") String keyword, @Param("keyword") String keyword1);
}
