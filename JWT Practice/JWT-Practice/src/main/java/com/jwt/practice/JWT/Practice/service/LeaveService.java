package com.jwt.practice.JWT.Practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jwt.practice.JWT.Practice.model.Leave;
import com.jwt.practice.JWT.Practice.model.LeaveRequest;
import com.jwt.practice.JWT.Practice.model.Status;
import com.jwt.practice.JWT.Practice.model.User;
import com.jwt.practice.JWT.Practice.repo.LeaveRepository;
import com.jwt.practice.JWT.Practice.repo.UserRepository;

@Service
public class LeaveService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private LeaveRepository leaveRepo;

	public ResponseEntity<?> createLeave(String username, LeaveRequest leaveRequest) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (!user.getRole().getRoleName().equalsIgnoreCase("USER")) {
				return ResponseEntity.status(401).body("Unauthorized!");
			}

			Leave leave = new Leave();
			leave.setCategory(leaveRequest.getCategory());
			leave.setDescription(leaveRequest.getDescription());
			leave.setAppliedOn(leaveRequest.getAppliedOn());
			leave.setNoOfDays(leaveRequest.getNoOfDays());
			leave.setStatus(Status.PENDING);
			leave.setUser(user);
			Leave savedLeave = leaveRepo.save(leave);

			return ResponseEntity.status(201).body(savedLeave);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}

	}

	public ResponseEntity<?> updateComment(String username, Long id, String comment) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (!user.getRole().getRoleName().equalsIgnoreCase("USER")) {
				return ResponseEntity.status(401).body("Unauthorized!");
			}

			Optional<Leave> optLeave = leaveRepo.findById(id);
			if (optLeave.isEmpty()) {
				return ResponseEntity.status(404).body("Leave Not Found");
			}

			Leave leave = optLeave.get();
			User userDB = leave.getUser();
			if (userDB.getId() != user.getId()) {
				return ResponseEntity.status(404).body("Leave Id Not Found for " + username);
			}

			leave.setDescription(comment);
			Leave savedLeave = leaveRepo.save(leave);

			return ResponseEntity.status(200).body(savedLeave);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}
	}

	public ResponseEntity<?> getLeavesByRole(String username) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (user.getRole().getRoleName().equalsIgnoreCase("USER")) {
				Optional<Leave> leavesByUsername = leaveRepo.findLeavesByUsername(user.getId());
				if (leavesByUsername.isEmpty()) {
					return ResponseEntity.status(404).body("No Leaves Found for " + username);
				}

				Leave allleaves = leavesByUsername.get();
				return ResponseEntity.status(200).body(allleaves);
			} else if (user.getRole().getRoleName().equalsIgnoreCase("ADMIN")) {
				List<Leave> allLeaves = leaveRepo.findAll();
				if (allLeaves.isEmpty()) {
					return ResponseEntity.status(404).body("Leaves Not Found");
				}

				return ResponseEntity.status(200).body(allLeaves);
			} else {
				return ResponseEntity.status(401).body("Unauthorized!");
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}
	}

	public ResponseEntity<?> updateStatus(String username, Long id, String status) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (!user.getRole().getRoleName().equalsIgnoreCase("ADMIN")) {
				return ResponseEntity.status(401).body("Unauthorized!");
			}

			Optional<Leave> optLeave = leaveRepo.findById(id);
			if (optLeave.isEmpty()) {
				return ResponseEntity.status(404).body("Leave Not Found");
			}

			Leave leave = optLeave.get();
//			if (leave.getUser().getId() != user.getId()) {
//				return ResponseEntity.status(404).body("Leave Id Not Found for " + username);
//			}

			leave.setStatus(Status.valueOf(status));
			Leave savedLeave = leaveRepo.save(leave);

			return ResponseEntity.status(200).body(savedLeave);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}
	}

	public ResponseEntity<?> deleteLeave(String username, Long id) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (!user.getRole().getRoleName().equalsIgnoreCase("ADMIN")) {
				return ResponseEntity.status(401).body("Unauthorized!");
			}
			Optional<Leave> optLeave = leaveRepo.findById(id);
			if (optLeave.isEmpty()) {
				return ResponseEntity.status(404).body("Leave Not Found");
			}

			Leave leave = optLeave.get();
//			if (user.getId() != leave.getUser().getId()) {
//				return ResponseEntity.status(404).body("Leave Id Not Found for " + username);
//			}
			leaveRepo.delete(leave);

			return ResponseEntity.status(204).body("Leave Deleted Successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}
	}

	public ResponseEntity<?> getLeaveByNoOfDays(String username, int noOfDays) {
		try {
			Optional<User> userOpt = getUserByUsername(username);
			// SANITY 1: User not exists
			if (userOpt.isEmpty()) {
				return ResponseEntity.status(404).body("User Doesn't Exists");
			}

			User user = userOpt.get();
			// SANITY 2: Role Sanity check
			if (!user.getRole().getRoleName().equalsIgnoreCase("ADMIN")) {
				return ResponseEntity.status(401).body("Unauthorized!");
			}

			List<Leave> allLeaves = leaveRepo.findAll();
			if (allLeaves.isEmpty()) {
				return ResponseEntity.status(404).body("No Leaves Found");
			}

			List<User> users = new ArrayList<>();
			for (int i = 0; i < allLeaves.size(); i++) {
				if (allLeaves.get(i).getNoOfDays() >= noOfDays) {
					users.add(allLeaves.get(i).getUser());
				}
			}

			return ResponseEntity.status(200).body(users);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error:" + e.getMessage());
		}
	}

	public Optional<User> getUserByUsername(String username) {
		return userRepo.findByEmail(username);
	}
}
