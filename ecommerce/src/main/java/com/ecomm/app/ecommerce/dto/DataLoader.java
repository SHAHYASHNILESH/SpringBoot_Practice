package com.ecomm.app.ecommerce.dto;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecomm.app.ecommerce.models.Cart;
import com.ecomm.app.ecommerce.models.CartProduct;
import com.ecomm.app.ecommerce.models.Category;
import com.ecomm.app.ecommerce.models.Product;
import com.ecomm.app.ecommerce.models.UserInfo;
import com.ecomm.app.ecommerce.repository.CartProductRepository;
import com.ecomm.app.ecommerce.repository.CartRepository;
import com.ecomm.app.ecommerce.repository.CategoryRepository;
import com.ecomm.app.ecommerce.repository.ProductRepository;
import com.ecomm.app.ecommerce.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

	private final UserInfoRepository userInfoRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final CartRepository cartRepository;
	private final CartProductRepository cartProductRepository;

	@Override
	public void run(String... args) throws Exception {

		// ---------------------- USERS ----------------------
		UserInfo buyer1 = new UserInfo(null, "jack", "pass_word", "CONSUMER");
		UserInfo buyer2 = new UserInfo(null, "bob", "pass_word", "CONSUMER");

		UserInfo seller1 = new UserInfo(null, "alice", "pass_word", "SELLER");
		UserInfo seller2 = new UserInfo(null, "fashionhub", "pass_word", "SELLER");

		userInfoRepository.saveAll(List.of(buyer1, buyer2, seller1, seller2));

		// ---------------------- CATEGORIES ----------------------
		Category electronics = new Category(null, "Smartphone");
		Category fashion = new Category(null, "Fashion");
		Category home = new Category(null, "Home & Kitchen");

		categoryRepository.saveAll(List.of(electronics, fashion, home));

		// ---------------------- PRODUCTS ----------------------
		Product phone = new Product(null, "Smartphone X", 699.99, seller1, electronics);
		Product laptop = new Product(null, "Laptop Pro", 1199.00, seller1, electronics);
		Product tshirt = new Product(null, "Casual T-Shirt", 19.99, seller2, fashion);
		Product jeans = new Product(null, "Denim Jeans", 49.99, seller2, fashion);
		Product blender = new Product(null, "Kitchen Blender", 89.50, seller1, home);
		Product vacuum = new Product(null, "Smart Vacuum", 299.00, seller1, home);

		List<Product> products = productRepository.saveAll(List.of(phone, laptop, tshirt, jeans, blender, vacuum));

		// ---------------------- CARTS ----------------------
		Cart cart1 = new Cart(null, 0.0, buyer1, null); // totalAmount will be updated
		Cart cart2 = new Cart(null, 0.0, buyer2, null);

		cart1 = cartRepository.save(cart1);
		cart2 = cartRepository.save(cart2);

		// ---------------------- CART PRODUCTS ----------------------
		CartProduct cp1 = new CartProduct(null, 0, 0, cart1, phone, 1);
		CartProduct cp2 = new CartProduct(null, 0, 0, cart1, tshirt, 2);
		CartProduct cp3 = new CartProduct(null, 0, 0, cart2, jeans, 1);
		CartProduct cp4 = new CartProduct(null, 0, 0, cart2, blender, 1);
		CartProduct cp5 = new CartProduct(null, 0, 0, cart2, phone, 1);

		List<CartProduct> cartProducts = cartProductRepository.saveAll(List.of(cp1, cp2, cp3, cp4, cp5));

		// Assign cartProducts to carts and calculate totalAmount
		cart1.setCartProducts(List.of(cp1, cp2));
		cart1.setTotalAmount(
				cp1.getProduct().getPrice() * cp1.getQuantity() + cp2.getProduct().getPrice() * cp2.getQuantity());
		cartRepository.save(cart1);

		cart2.setCartProducts(List.of(cp3, cp4, cp5));
		cart2.setTotalAmount(cp3.getProduct().getPrice() * cp3.getQuantity()
				+ cp4.getProduct().getPrice() * cp4.getQuantity() + cp5.getProduct().getPrice() * cp5.getQuantity());
		cartRepository.save(cart2);

		System.out.println("✅ Sample data loaded: Users, Categories, Products, Carts, and Cart Products.");
	}
}
