package com.ecomm.app.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.app.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(String productName,
			String categoryName);

	List<Product> findByUserInfoId(Long sellerId);

	Optional<Product> findByUserInfoIdAndProductId(Long sellerId, Long productId);
}
