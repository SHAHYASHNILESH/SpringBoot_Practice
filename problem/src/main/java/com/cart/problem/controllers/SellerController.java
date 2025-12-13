package com.cart.problem.controllers;

import com.cart.problem.dto.SellerResponse;
import com.cart.problem.models.Category;
import com.cart.problem.models.Product;
import com.cart.problem.models.UserInfo;
import com.cart.problem.repo.CategoryRepository;
import com.cart.problem.repo.ProductRepository;
import com.cart.problem.repo.UserRepository;
import com.cart.problem.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/seller")
public class SellerController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/product/{productId}")
    public ResponseEntity<?> getProducts(@RequestHeader("Authorization") String header, @PathVariable Long productId) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            UserInfo userInfo = optionalUserInfo.get();

            if (!userInfo.getRoles().equalsIgnoreCase("SELLER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Product> byProductIdAndSellerUserId = productRepository.findByProductIdAndSellerUserId(productId, userInfo.getUserId());
            if (!byProductIdAndSellerUserId.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            Product product = byProductIdAndSellerUserId.get();
            return ResponseEntity.status(200).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestHeader("Authorization") String header, @RequestBody Product product) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            UserInfo userInfo = optionalUserInfo.get();

            if (!userInfo.getRoles().equalsIgnoreCase("SELLER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Category> byCategoryName = categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
            if (!byCategoryName.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            Category cat = byCategoryName.get();

            Product p = new Product();
            p.setProductName(product.getProductName());
            p.setCategory(cat);
            p.setPrice(product.getPrice());
            p.setSeller(userInfo);

            categoryRepository.save(cat);
            Product savedProd = productRepository.save(p);
            String redirectUrl = "http://localhost:8080/api/auth/seller/product/" + savedProd.getProductId();
            return ResponseEntity.status(201).body(new SellerResponse(savedProd, redirectUrl));
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProductsOfSeller(@RequestHeader("Authorization") String header) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            UserInfo userInfo = optionalUserInfo.get();

            if (!userInfo.getRoles().equalsIgnoreCase("SELLER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            List<Product> bySeller = productRepository.findBySeller(userInfo);
            if (bySeller.isEmpty()) {
                return ResponseEntity.status(400).build();
            }

            return ResponseEntity.status(200).body(bySeller);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestHeader("Authorization") String header, @RequestBody Product product) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            UserInfo userInfo = optionalUserInfo.get();

            if (!userInfo.getRoles().equalsIgnoreCase("SELLER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Category> byCategoryName = categoryRepository.findByCategoryName(product.getCategory().getCategoryName());
            if (!byCategoryName.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            Category cat = byCategoryName.get();

            Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
            if (!optionalProduct.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            Product product1 = optionalProduct.get();
            product1.setProductName(product.getProductName());
            product1.setPrice(product.getPrice());
            product1.setCategory(cat);

            categoryRepository.save(cat);
            Product prod1 = productRepository.save(product1);

            return ResponseEntity.status(200).body(prod1);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@RequestHeader("Authorization") String header, @PathVariable Long productId) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            UserInfo userInfo = optionalUserInfo.get();

            if (!userInfo.getRoles().equalsIgnoreCase("SELLER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Product> byProductIdAndSellerUserId = productRepository.findByProductIdAndSellerUserId(productId, userInfo.getUserId());
            if (!byProductIdAndSellerUserId.isPresent()) {
                return ResponseEntity.status(404).build();
            }

            Product product = byProductIdAndSellerUserId.get();
            productRepository.delete(product);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
