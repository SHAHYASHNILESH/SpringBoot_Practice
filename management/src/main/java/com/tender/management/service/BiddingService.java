package com.tender.management.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tender.management.model.BiddingModel;
import com.tender.management.model.UserModel;
import com.tender.management.repo.BiddingRepository;
import com.tender.management.repo.UserRepository;
import com.tender.management.security.JWTUtil;

@Service
public class BiddingService {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BiddingRepository biddingRepository;

	public ResponseEntity<?> postBidding(String header, BiddingModel biddingModel) {
		// TODO Auto-generated method stub
		try {
			String token = header.substring(7);
			String username = jwtUtil.extractUsername(token);

			Optional<UserModel> byEmail = userRepository.findByEmail(username);
			if (byEmail.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserModel userModel = byEmail.get();
			System.out.println(userModel.getRole().getRoleName());
			if (!userModel.getRole().getRoleName().equals("BIDDER")) {
				return ResponseEntity.status(401).build();
			}

			biddingModel.setBidderId(userModel.getId().intValue());
			biddingModel.setDateOfBinding(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			BiddingModel save = biddingRepository.save(biddingModel);
			return ResponseEntity.status(201).body(save);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> getBidding(String header, double value) {
		// TODO Auto-generated method stub
		try {
			String token = header.substring(7);
			String username = jwtUtil.extractUsername(token);

			Optional<UserModel> byEmail = userRepository.findByEmail(username);
			if (byEmail.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserModel userModel = byEmail.get();
			List<BiddingModel> all = biddingRepository.findAll();
			if (all.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			List<BiddingModel> save = new ArrayList<>();
			for (int i = 0; i < all.size(); i++) {
				if (all.get(i).getBidAmount() > value) {
					save.add(all.get(i));
				}
			}

			return ResponseEntity.status(200).body(save);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> updateBidding(String header, Long id, BiddingModel biddingModel) {
		// TODO Auto-generated method stub
		try {
			String token = header.substring(7);
			String username = jwtUtil.extractUsername(token);

			Optional<UserModel> byEmail = userRepository.findByEmail(username);
			if (byEmail.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			UserModel userModel = byEmail.get();
			System.out.println(userModel.getRole().getRoleName());
			if (!userModel.getRole().getRoleName().equals("APPROVER")) {
				return ResponseEntity.status(401).build();
			}

			Optional<BiddingModel> byId = biddingRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(400).build();
			}
			BiddingModel model = byId.get();
			model.setStatus(biddingModel.getStatus());
			BiddingModel save = biddingRepository.save(model);

			return ResponseEntity.status(200).body(save);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

	public ResponseEntity<?> deleteBidding(String header, Long id) {
		// TODO Auto-generated method stub
		try {
			String token = header.substring(7);
			String username = jwtUtil.extractUsername(token);

			Optional<UserModel> byEmail = userRepository.findByEmail(username);
			if (byEmail.isEmpty()) {
				return ResponseEntity.status(400).build();
			}

			Optional<BiddingModel> byId = biddingRepository.findById(id);
			if (byId.isEmpty()) {
				return ResponseEntity.status(400).body("not found");
			}

			UserModel userModel = byEmail.get();
			if (!userModel.getRole().getRoleName().equals("APPROVER")
					&& userModel.getId().intValue() != byId.get().getBidderId()) {
				return ResponseEntity.status(403).body("you don't have permission");
			}

			biddingRepository.delete(byId.get());
			return ResponseEntity.status(204).body("deleted successfully");

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(400).build();
		}
	}

}
