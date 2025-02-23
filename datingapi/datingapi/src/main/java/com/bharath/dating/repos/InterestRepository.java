package com.bharath.dating.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.dating.entities.Interest;

public interface InterestRepository extends JpaRepository<Interest, Integer> {

}
