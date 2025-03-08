package com.relationships.RelationshipMappings.oneToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationships.RelationshipMappings.oneToMany.entity.Item;
import com.relationships.RelationshipMappings.oneToMany.exception.ResourceNotFoundException;
import com.relationships.RelationshipMappings.oneToMany.repo.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;

	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public Item addItem(Item item) {

		return itemRepository.save(item);

	}

	public List<Item> getAllItems() {

		return itemRepository.findAll();

	}

	public Item getItemById(Long id) throws ResourceNotFoundException {

		return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));

	}

	public Item updateItem(Long id, Item item) throws ResourceNotFoundException {

		Item existingItem = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));

		existingItem.setSerialNumber(item.getSerialNumber());
		return itemRepository.save(existingItem);

	}

	public Item deleteItem(Long id) throws ResourceNotFoundException {

		Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
		itemRepository.delete(item);
		return item;

	}
}
