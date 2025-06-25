package com.ecomm.app.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.app.ecommerce.models.CartProduct;

import jakarta.transaction.Transactional;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

	Optional<CartProduct> findByCartUserInfoIdAndProductProductId(Long userId, Long productId);

	@Transactional
	void deleteByCartUserInfoIdAndProductProductId(Long userId, Long productId);

}
