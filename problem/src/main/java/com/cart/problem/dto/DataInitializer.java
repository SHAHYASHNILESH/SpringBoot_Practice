package com.cart.problem.dto;

import com.cart.problem.models.*;
import com.cart.problem.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            CartRepository cartRepository,
            CartProductRepository cartProductRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {

            // -------------------------------------------------------
            // 1. Insert Categories
            // -------------------------------------------------------
            List<String> categoryList = Arrays.asList(
                    "Fashion", "Electronics", "Books", "Groceries", "Medicines"
            );

            for (String cat : categoryList) {
                categoryRepository.findByCategoryName(cat)
                        .orElseGet(() -> categoryRepository.save(
                                new Category(0, cat)
                        ));
            }

            Category electronics = categoryRepository.findByCategoryName("Electronics").get();
            Category medicines = categoryRepository.findByCategoryName("Medicines").get();


            // -------------------------------------------------------
            // 2. Insert Users
            // -------------------------------------------------------
            UserInfo jack = insertUserIfNotExists(userRepository, passwordEncoder,
                    "jack", "pass_word", "CONSUMER");

            UserInfo bob = insertUserIfNotExists(userRepository, passwordEncoder,
                    "bob", "pass_word", "CONSUMER");

            UserInfo apple = insertUserIfNotExists(userRepository, passwordEncoder,
                    "apple", "pass_word", "SELLER");

            UserInfo glaxo = insertUserIfNotExists(userRepository, passwordEncoder,
                    "glaxo", "pass_word", "SELLER");


            // -------------------------------------------------------
            // 3. Insert Products
            // -------------------------------------------------------
            // productId auto-generated so we check using name + seller

            insertProductIfNotExists(productRepository,
                    "Apple iPad 10.2 8th Gen WiFi iOS Tablet",
                    29190,
                    electronics,
                    apple);

            insertProductIfNotExists(productRepository,
                    "Crocin pain relief tablet",
                    10,
                    medicines,
                    glaxo);


            // -------------------------------------------------------
            // 4. Insert Carts
            // (totalAmount, user)
            // -------------------------------------------------------
            Cart cart1 = insertCartIfNotExists(cartRepository, 20, jack);
            Cart cart2 = insertCartIfNotExists(cartRepository, 0, bob);


            // -------------------------------------------------------
            // 5. Insert Cart Products
            // (cartId, productId, quantity)
            // -------------------------------------------------------
            Product ipad = productRepository.findByProductName("Apple iPad 10.2 8th Gen WiFi iOS Tablet").get();
            Product crocin = productRepository.findByProductName("Crocin pain relief tablet").get();

            insertCartProductIfNotExists(cartProductRepository, cart1, ipad, 2);
            insertCartProductIfNotExists(cartProductRepository, cart1, ipad, 2);

            System.out.println("✅ Database Initialized Successfully.");
        };
    }


    // ===================================================================
    // HELPER METHODS
    // ===================================================================

    private UserInfo insertUserIfNotExists(
            UserRepository repo, PasswordEncoder encoder,
            String username, String password, String role
    ) {
        return repo.findByUsername(username)
                .orElseGet(() -> repo.save(
                        new UserInfo(null, username, encoder.encode(password), role)
                ));
    }

    private Product insertProductIfNotExists(
            ProductRepository repo,
            String name,
            double price,
            Category category,
            UserInfo seller
    ) {
        return repo.findByProductName(name)
                .orElseGet(() -> repo.save(
                        new Product(0, name, price, seller, category)
                ));
    }

    private Cart insertCartIfNotExists(CartRepository repo, double totalAmount, UserInfo user) {
        return repo.findByUser(user)
                .orElseGet(() -> repo.save(
                        new Cart(0, totalAmount, user, null)
                ));
    }

    private CartProduct insertCartProductIfNotExists(
            CartProductRepository repo,
            Cart cart,
            Product product,
            int qty
    ) {
        return repo.findByCartAndProduct(cart, product)
                .orElseGet(() -> repo.save(
                        new CartProduct(0, cart.getCartId(), product.getProductId(), cart, product, qty)
                ));
    }

}
