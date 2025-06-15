package com.jwt.practice.JWT.Practice.controller;

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

import com.jwt.practice.JWT.Practice.model.LeaveRequest;
import com.jwt.practice.JWT.Practice.service.LeaveService;
import com.jwt.practice.JWT.Practice.util.JwtUtil;

@RestController
@RequestMapping("/leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/user")
	public ResponseEntity<?> createLeave(@RequestHeader("Authorization") String authHeader,
			@RequestBody LeaveRequest leaveRequest) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);

		return leaveService.createLeave(username, leaveRequest);
	}

	@PutMapping("/comment")
	public ResponseEntity<?> updateComment(@RequestHeader("Authorization") String authHeader, @RequestParam Long id,
			@RequestParam String comment) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		
		return leaveService.updateComment(username, id, comment);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getLeavesByRole(@RequestHeader("Authorization") String authHeader) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		
		return leaveService.getLeavesByRole(username);
	}

	@PutMapping("/status")
	public ResponseEntity<?> updateStatus(@RequestHeader("Authorization") String authHeader, @RequestParam Long id,
			@RequestParam String status) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		
		return leaveService.updateStatus(username, id, status);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLeave(@RequestHeader("Authorization") String authHeader, @PathVariable Long id) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		
		return leaveService.deleteLeave(username, id);
	}

	@GetMapping("/days")
	public ResponseEntity<?> getLeaveByNoOfDays(@RequestHeader("Authorization") String authHeader,
			@RequestParam int noOfDays) {
		String token = authHeader.substring(7);
		String username = jwtUtil.extractUsername(token);
		
		return leaveService.getLeaveByNoOfDays(username, noOfDays);
	}
}
