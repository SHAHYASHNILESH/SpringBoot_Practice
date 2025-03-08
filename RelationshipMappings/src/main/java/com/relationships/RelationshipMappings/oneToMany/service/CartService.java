package com.relationships.RelationshipMappings.oneToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationships.RelationshipMappings.oneToMany.entity.Cart;
import com.relationships.RelationshipMappings.oneToMany.entity.Item;
import com.relationships.RelationshipMappings.oneToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.oneToMany.repo.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemService itemService;

	public Cart addCart(Cart cart) {

		return cartRepository.save(cart);

	}

	public Cart getCart(Long id) throws ResourceNotFoundException {

		return cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));

	}

	public List<Cart> getAllCarts() {

		return cartRepository.findAll();

	}

	public Cart updateCart(Long id, Cart cart) throws ResourceNotFoundException {

		Cart existingCart = cartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));

		existingCart.setName(cart.getName());
		return cartRepository.save(existingCart);

	}

	public Cart deleteCart(Long id) throws ResourceNotFoundException {

		Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));

		cartRepository.delete(cart);
		return cart;

	}

	public Cart addItemToCart(Long id, Long itemId) throws ResourceNotFoundException {

		Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
		Item item = itemService.getItemById(itemId);

		item.setCart(cart);
//		cart.addItem(item);
		return cartRepository.save(cart);

	}

	public Cart removeItemFromCart(Long id, Long itemId) throws ResourceNotFoundException {

		Cart cart = cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
		Item item = itemService.getItemById(itemId);

		item.setCart(null);

		return cartRepository.save(cart);

	}

}
