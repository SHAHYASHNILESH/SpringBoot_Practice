package com.tender_management.tender_management_system.service;

import com.tender_management.tender_management_system.entity.BiddingModel;
import com.tender_management.tender_management_system.entity.UserInfo;
import com.tender_management.tender_management_system.repository.BiddingRepository;
import com.tender_management.tender_management_system.repository.UserRepository;
import com.tender_management.tender_management_system.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BiddingService {
    @Autowired
    private BiddingRepository biddingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> addBidding(String header, BiddingModel biddingModel) {
        try {
            String token = header.substring(7);
            String username = jwtUtils.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByEmail(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo userInfo = optionalUserInfo.get();
            if (!userInfo.getRole().getRoleName().equalsIgnoreCase("BIDDER")) {
                return ResponseEntity.status(403).body("Forbidden!");
            }

            biddingModel.setBidderId(userInfo.getId().intValue());
            biddingModel.setDateOfBidding(String.valueOf(LocalDate.now()));
            BiddingModel savedBidding = biddingRepository.save(biddingModel);

            return ResponseEntity.status(201).body(savedBidding);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<?> getBidDetails(String header, Double bidAmount) {
        try {
            String token = header.substring(7);
            String username = jwtUtils.extractUsername(token);

            Optional<UserInfo> optionalUserInfo = userRepository.findByEmail(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            List<BiddingModel> biddingModels = biddingRepository.findByAmount(bidAmount);
            if (biddingModels.isEmpty()) {
                return ResponseEntity.status(400).build();
            }

            return ResponseEntity.status(200).body(biddingModels);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<?> updateBiddingStatus(String header, Long id, BiddingModel biddingModel) {
        try {
            String token = header.substring(7);
            String username = jwtUtils.extractUsername(token);
            Optional<UserInfo> optionalUserInfo = userRepository.findByEmail(username);
            if (!optionalUserInfo.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            UserInfo userInfo = optionalUserInfo.get();
            if (!userInfo.getRole().getRoleName().equalsIgnoreCase("APPROVER")) {
                return ResponseEntity.status(403).body("Forbidden!");
            }

            Optional<BiddingModel> optionalBiddingModel = biddingRepository.findById(id);
            if (!optionalBiddingModel.isPresent()) {
                return ResponseEntity.status(400).build();
            }

            BiddingModel model = optionalBiddingModel.get();
            model.setStatus(biddingModel.getStatus());
            BiddingModel savedBid = biddingRepository.save(model);

            return ResponseEntity.status(200).body(savedBid);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
