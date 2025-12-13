package com.cart.problem.controllers;

import com.cart.problem.models.*;
import com.cart.problem.repo.*;
import com.cart.problem.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/consumer")
public class ConsumerController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/cart")
    public ResponseEntity<?> getConsumerCart(@RequestHeader("Authorization") String header) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);
            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo user = optionalUserInfo.get();
            if (!user.getRoles().equalsIgnoreCase("CONSUMER")) {
                return ResponseEntity.status(403).body("Forbidden");
            }

            Optional<Cart> optionalCart = cartRepository.findByUser(user);
            if (!optionalCart.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            Cart cart = optionalCart.get();
            return ResponseEntity.status(200).body(cart);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addProdToCart(@RequestHeader("Authorization") String header, @RequestBody Product product) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo user = optionalUserInfo.get();
            if (!user.getRoles().equalsIgnoreCase("CONSUMER")) {
                return ResponseEntity.status(403).body("Forbidden");
            }

            Optional<Cart> optionalCart = cartRepository.findByUser(user);
            if (!optionalCart.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            Cart cart = optionalCart.get();

            List<CartProduct> cartProds = cart.getCartProducts();
            for (CartProduct cartProduct : cartProds) {
                if (cartProduct.getProductId() == product.getProductId()) {
                    return ResponseEntity.status(409).build();
                }
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
            p.setSeller(user);

            categoryRepository.save(cat);
            Product savedProd = productRepository.save(p);

            CartProduct cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setCartId(cart.getCartId());
            cartProduct.setProduct(savedProd);
            cartProduct.setProductId(savedProd.getProductId());
            cartProds.add(cartProduct);
            cart.setCartProducts(cartProds);
            Cart savedCart = cartRepository.save(cart);
            return ResponseEntity.status(201).body(savedCart);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/cart")
    public ResponseEntity<?> updateCart(@RequestHeader("Authorization") String header, @RequestBody CartProduct cartProduct) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);
            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo userInfo = optionalUserInfo.get();
            if (!userInfo.getRoles().equalsIgnoreCase("CONSUMER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Cart> optionalCart = cartRepository.findByUser(userInfo);
            if (!optionalCart.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            Cart cart = optionalCart.get();

            Optional<CartProduct> byProduct = cartProductRepository.findByProduct(cartProduct.getProduct());
            if (!byProduct.isPresent()) {
                Optional<Category> byCategoryName = categoryRepository.findByCategoryName(cartProduct.getProduct().getCategory().getCategoryName());
                if (!byCategoryName.isPresent()) {
                    return ResponseEntity.status(400).build();
                }
                Category cat = byCategoryName.get();

                Product p = new Product();
                p.setProductName(cartProduct.getProduct().getProductName());
                p.setCategory(cat);
                p.setPrice(cartProduct.getProduct().getPrice());
                p.setSeller(userInfo);

                categoryRepository.save(cat);
                Product savedProd = productRepository.save(p);

                CartProduct cartProduct1 = new CartProduct();
                cartProduct1.setCart(cart);
                cartProduct1.setCartId(cart.getCartId());
                cartProduct1.setProduct(savedProd);
                cartProduct1.setProductId(savedProd.getProductId());
                cartProduct1.setQuantity(cartProduct1.getQuantity());
                CartProduct savedCartProd = cartProductRepository.save(cartProduct1);
                return ResponseEntity.status(200).body(savedCartProd);
            }

            CartProduct cartProduct1 = byProduct.get();
            if (cartProduct1.getQuantity() == 0) {
                cartProductRepository.delete(cartProduct1);
                return ResponseEntity.status(200).build();
            }
            cartProduct1.setQuantity(cartProduct.getQuantity());
            CartProduct savedCartProd = cartProductRepository.save(cartProduct1);
            return ResponseEntity.status(200).body(savedCartProd);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/cart")
    public ResponseEntity<?> deleteProdFromCart(@RequestHeader("Authorization") String header, @RequestBody Product product) {
        try {
            String token = header.substring(7);
            String username = jwtService.extractUsername(token);
            Optional<UserInfo> optionalUserInfo = userRepository.findByUsername(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo userInfo = optionalUserInfo.get();
            if (!userInfo.getRoles().equalsIgnoreCase("CONSUMER")) {
                return ResponseEntity.status(403).body("Forbidden!!");
            }

            Optional<Cart> optionalCart = cartRepository.findByUser(userInfo);
            if (!optionalCart.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            Cart cart = optionalCart.get();

            Optional<CartProduct> byProduct = cartProductRepository.findByCartAndProduct(cart, product);
            if (!byProduct.isPresent()) {
                return ResponseEntity.status(400).build();
            }
            CartProduct cartProduct = byProduct.get();

            cart.getCartProducts().remove(cartProduct);
            cartProductRepository.delete(cartProduct);
            cartRepository.save(cart);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
