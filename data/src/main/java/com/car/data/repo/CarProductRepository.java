package com.car.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.data.entity.CarProduct;

public interface CarProductRepository extends JpaRepository<CarProduct, Integer> {

}
