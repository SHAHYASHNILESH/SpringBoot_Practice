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

import com.relationships.RelationshipMappings.oneToMany.entity.Item;
import com.relationships.RelationshipMappings.oneToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.oneToMany.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public List<Item> getAllItems() {

		return itemService.getAllItems();

	}

	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable Long id) throws ResourceNotFoundException {

		return itemService.getItemById(id);

	}

	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {

		return itemService.addItem(item);

	}

	@PutMapping("/items/{id}")
	public Item updateItem(@PathVariable Long id, @RequestBody Item item) throws ResourceNotFoundException {

		return itemService.updateItem(id, item);

	}

	@DeleteMapping("/items/{id}")
	public Item deleteItem(@PathVariable Long id) throws ResourceNotFoundException {

		return itemService.deleteItem(id);

	}
}
