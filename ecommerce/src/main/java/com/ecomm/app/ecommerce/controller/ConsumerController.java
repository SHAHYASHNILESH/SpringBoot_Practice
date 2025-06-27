package com.ecomm.app.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.app.ecommerce.models.Cart;
import com.ecomm.app.ecommerce.models.CartProduct;
import com.ecomm.app.ecommerce.models.Product;
import com.ecomm.app.ecommerce.models.UserInfo;
import com.ecomm.app.ecommerce.repository.CartProductRepository;
import com.ecomm.app.ecommerce.repository.CartRepository;
import com.ecomm.app.ecommerce.repository.ProductRepository;
import com.ecomm.app.ecommerce.repository.UserInfoRepository;
import com.ecomm.app.ecommerce.service.JwtService;

@RestController
@RequestMapping("/api/auth/consumer")
@SuppressWarnings("unlikely-arg-type")
public class ConsumerController {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/cart")
	public ResponseEntity<?> getConsumerCart(@RequestHeader("Authorization") String header) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRoles().equalsIgnoreCase("SELLER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Cart> consumerCart = cartRepository.findByUserInfoUsername(user.getUsername());
			if (consumerCart.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Cart cart = consumerCart.get();
			return ResponseEntity.status(200).body(cart);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

	@PostMapping("/cart")
	public ResponseEntity<?> addCart(@RequestHeader("Authorization") String header, @RequestBody Product product) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> byUsername = userInfoRepository.findByUsername(username);
			if (byUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = byUsername.get();
			if (user.getRoles().equalsIgnoreCase("SELLER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Cart> byUserInfoUsername = cartRepository.findByUserInfoUsername(user.getUsername());
			if (byUserInfoUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Cart cart = byUserInfoUsername.get();
			Optional<Product> optProd = productRepository.findById(product.getProductId());
			if (optProd.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Product prod = optProd.get();
			if (cart.getCartProducts().size() > 0
					&& !cart.getCartProducts().stream().anyMatch(cp -> cp.getProduct().equals(prod))) {
				CartProduct cProduct = new CartProduct();
				cProduct.setCart(cart);
				cProduct.setProduct(prod);
				cart.getCartProducts().add(cProduct);

				cartRepository.save(cart);
				return ResponseEntity.status(201).body(cart);
			}

			return ResponseEntity.status(409).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

	@PutMapping("/cart")
	public ResponseEntity<?> updateCart(@RequestHeader("Authorization") String header,
			@RequestBody CartProduct cartProduct) {
		try {
			String token = header.substring(7);
			String username = jwtService.extractUsername(token);

			Optional<UserInfo> userOptional = userInfoRepository.findByUsername(username);
			if (userOptional.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserInfo user = userOptional.get();
			if (user.getRoles().equalsIgnoreCase("SELLER")) {
				return ResponseEntity.status(401).body("Unauthorized");
			}

			Optional<Cart> byUserInfoUsername = cartRepository.findByUserInfoUsername(username);
			if (byUserInfoUsername.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Cart cart = byUserInfoUsername.get();
			List<CartProduct> cartProducts = cart.getCartProducts();
			if (cartProducts.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			if (cart.getCartProducts().size() > 0 && cart.getCartProducts().stream()
					.anyMatch(cp -> cp.getProduct().equals(cartProduct.getProduct()))) {
				CartProduct cProduct = cart.getCartProducts().get(cart.getCartProducts().indexOf(cartProduct));
				if (cProduct.getQuantity() == 0) {
					cart.getCartProducts().remove(cProduct);
				} else {
					cart.getCartProducts().set(cart.getCartProducts().indexOf(cartProduct), cartProduct);
				}
				cartRepository.save(cart);
			} else {
				cart.getCartProducts().add(cartProduct);
				cartRepository.save(cart);
			}
			
			return ResponseEntity.status(200).body(cart);
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
}
