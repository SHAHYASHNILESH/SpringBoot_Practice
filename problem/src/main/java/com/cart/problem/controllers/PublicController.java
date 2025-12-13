package com.cart.problem.controllers;

import com.cart.problem.models.Product;
import com.cart.problem.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/search")
    public ResponseEntity<?> searchProducts(@RequestParam String keyword) {
        try {
            List<Product> productsList = productRepository.findByProductNameContainingIgnoreCaseOrCategoryCategoryNameContainingIgnoreCase(keyword, keyword);
            if (productsList.isEmpty()) {
                return ResponseEntity.status(400).build();
            }

            return ResponseEntity.status(200).body(productsList);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
