package com.car.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.data.entity.CarProduct;
import com.car.data.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/carData/add")
	public Object addCarData(@RequestBody CarProduct carProduct) {
		return carService.addCarData(carProduct);
	}

	@GetMapping("/carData/list")
	public Object getCarData() {
		return carService.getCarData();
	}
	
	@PutMapping("/carData/update/{id}")
	public Object updateCarData(@PathVariable int id,@RequestBody CarProduct carProduct) {
		return carService.updateCarData(id, carProduct);
	}
	
	@DeleteMapping("/carData/delete/{id}")
	public Object deleteCarData(@PathVariable int id) {
		return carService.deleteCarData(id);
	}
}
