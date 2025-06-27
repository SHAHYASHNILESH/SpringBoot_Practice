package com.warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.warehouse.dto.ProdRequest;
import com.warehouse.warehouse.service.WarehouseService;

@RestController
@RequestMapping("/product")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;

	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestHeader("Authorization") String header,
			@RequestBody ProdRequest prodRequest) {
		return warehouseService.addProduct(header, prodRequest);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getProduct(@RequestHeader("Authorization") String header) {
		return warehouseService.getProduct(header);
	}

	@GetMapping("/vendor")
	public ResponseEntity<?> getSimilarVendor(@RequestHeader("Authorization") String header,
			@RequestParam String value) {
		return warehouseService.getSimilarVendor(header, value);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@RequestHeader("Authorization") String header, @PathVariable Long id,
			@RequestBody ProdRequest prodRequest) {
		return warehouseService.updateProduct(header, id, prodRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@RequestHeader("Authorization") String header, @PathVariable Long id) {
		return warehouseService.deleteProduct(header, id);
	}
}
