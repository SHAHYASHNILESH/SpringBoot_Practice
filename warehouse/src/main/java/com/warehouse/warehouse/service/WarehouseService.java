package com.warehouse.warehouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.warehouse.warehouse.dto.ProdRequest;
import com.warehouse.warehouse.entity.Product;
import com.warehouse.warehouse.entity.UserInfo;
import com.warehouse.warehouse.repository.ProductRepository;
import com.warehouse.warehouse.repository.UserInfoRepository;

@Service
public class WarehouseService {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<?> addProduct(String header, ProdRequest prodRequest) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRole().equals("USER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Product> bySku = productRepository.findBySku(prodRequest.getSku());
			if (!bySku.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Product prod = new Product();
			prod.setName(prodRequest.getName());
			prod.setDescription(prodRequest.getDescription());
			prod.setVendor(prodRequest.getVendor());
			prod.setPrice(prodRequest.getPrice());
			prod.setStock(prodRequest.getStock());
			prod.setCurrency(prodRequest.getCurrency());
			prod.setImage_url(prodRequest.getImage_url());
			prod.setSku(prodRequest.getSku());

			Optional<UserInfo> byUsername2 = userInfoRepository.findByUsername(prodRequest.getTargetUsername());
			if (byUsername2.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo userInfo = byUsername2.get();
			prod.setUser(userInfo);
			Product savedProd = productRepository.save(prod);

			return ResponseEntity.status(201).body(savedProd);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}

	}

	public ResponseEntity<?> getProduct(String header) {
		try {

			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRole().equals("ADMIN")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}
			List<Product> allProducts = productRepository.findAll();
			if (allProducts.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			if (allProducts.size() > 0 && allProducts.stream().anyMatch(e -> e.getUser().equals(user))) {
				return ResponseEntity.status(200)
						.body(allProducts.stream().filter(e -> e.getUser().equals(user)).toList());
			} else {
				return ResponseEntity.status(400).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> getSimilarVendor(String header, String value) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRole().equals("ADMIN")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			List<Product> byVendor = productRepository.findByVendor(value);
			if (byVendor.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			return ResponseEntity.status(200).body(byVendor);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> updateProduct(String header, Long id, ProdRequest prodRequest) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRole().equals("USER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Product> byId = productRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(400).build();
			}
			Product product = byId.get();
			product.setStock(prodRequest.getStock());
			product.setPrice(prodRequest.getPrice());
			Product save = productRepository.save(product);
			return ResponseEntity.status(200).body(save);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> deleteProduct(String header, Long id) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRole().equals("USER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Product> byId = productRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Product product = byId.get();
			productRepository.delete(product);

			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

}
