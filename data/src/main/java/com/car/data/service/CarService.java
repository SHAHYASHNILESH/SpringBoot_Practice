package com.car.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.car.data.entity.CarProduct;
import com.car.data.repo.CarProductRepository;

@Service
public class CarService {

	@Autowired
	private CarProductRepository carProductRepository;

	public Object addCarData(CarProduct carProduct) {
		try {
			CarProduct savedProduct = carProductRepository.save(carProduct);
			return ResponseEntity.status(201).body(savedProduct);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public Object getCarData() {
		try {
			List<CarProduct> allProducts = carProductRepository.findAll();
			if (allProducts.isEmpty()) {
				return ResponseEntity.status(400).body("No Data Available");
			}

			return ResponseEntity.status(200).body(allProducts);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public Object updateCarData(int id, CarProduct carProduct) {
		try {
			Optional<CarProduct> byId = carProductRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			CarProduct cProduct = byId.get();
			cProduct.setPrice(carProduct.getPrice());
			CarProduct save = carProductRepository.save(cProduct);

			return ResponseEntity.status(200).body(save);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public Object deleteCarData(int id) {
		try {
			Optional<CarProduct> byId = carProductRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(404).body("Not Found");
			}

			CarProduct cProduct = byId.get();
			carProductRepository.delete(cProduct);
			return ResponseEntity.status(200).build();
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}

}
