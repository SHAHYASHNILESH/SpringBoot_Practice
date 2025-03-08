package com.relationships.RelationshipMappings.oneToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationships.RelationshipMappings.oneToMany.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
