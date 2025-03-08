package com.relationships.RelationshipMappings.oneToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relationships.RelationshipMappings.oneToMany.entity.Cart;
import com.relationships.RelationshipMappings.oneToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.oneToMany.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/carts")
	public List<Cart> getAllCarts() {

		return cartService.getAllCarts();

	}

	@GetMapping("/carts/{id}")
	public Cart getCart(@PathVariable Long id) throws ResourceNotFoundException {

		return cartService.getCart(id);

	}

	@PostMapping("/carts/{id}/items/{itemId}")
	public Cart addItemToCart(@PathVariable Long id, @PathVariable Long itemId) throws ResourceNotFoundException {

		return cartService.addItemToCart(id, itemId);

	}

	@PostMapping("/carts/{id}/items/{itemId}/remove")
	public Cart removeItemFromCart(@PathVariable Long id, @PathVariable Long itemId) throws ResourceNotFoundException {

		return cartService.removeItemFromCart(id, itemId);

	}

	@PostMapping("/carts")
	public Cart addCart(@RequestBody Cart cart) {

		return cartService.addCart(cart);

	}

	@PutMapping("/carts/{id}")
	public Cart updateCart(@PathVariable Long id, @RequestBody Cart cart) throws ResourceNotFoundException {

		return cartService.updateCart(id, cart);

	}

	@DeleteMapping("/carts/{id}")
	public Cart deleteCart(@PathVariable Long id) throws ResourceNotFoundException {

		return cartService.deleteCart(id);

	}
}
