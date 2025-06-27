package com.ecomm.app.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.app.ecommerce.models.Product;
import com.ecomm.app.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/public")
public class PublicController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/product/search")
	public ResponseEntity<?> getProducts(@RequestParam String keyword) {
		try {
			List<Product> prods = productRepository
					.findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(keyword, keyword);
			if (prods.isEmpty()) {
				return ResponseEntity.status(400).body("No Products Found");
			}
			return ResponseEntity.status(200).body(prods);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
