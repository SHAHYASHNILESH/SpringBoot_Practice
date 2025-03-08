package com.relationships.RelationshipMappings.oneToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relationships.RelationshipMappings.oneToMany.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
