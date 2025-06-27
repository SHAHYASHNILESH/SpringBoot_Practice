package com.tender.management.controller;

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

import com.tender.management.model.BiddingModel;
import com.tender.management.service.BiddingService;

@RestController
@RequestMapping("/product")
public class BiddingController {

	@Autowired
	private BiddingService biddingService;

	@PostMapping("/add")
	public ResponseEntity<?> postBidding(@RequestHeader("Authorization") String header,
			@RequestBody BiddingModel biddingModel) {
		return biddingService.postBidding(header, biddingModel);
	}

	@GetMapping("/get")
	public ResponseEntity<?> getBidding(@RequestHeader("Authorization") String header, @RequestParam double value) {
		return biddingService.getBidding(header, value);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBidding(@RequestHeader("Authorization") String header, @PathVariable Long id,
			@RequestBody BiddingModel biddingModel) {
		return biddingService.updateBidding(header, id, biddingModel);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBidding(@RequestHeader("Authorization") String header, @PathVariable Long id) {
		return biddingService.deleteBidding(header, id);
	}
}
