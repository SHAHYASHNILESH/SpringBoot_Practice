package com.tender_management.tender_management_system.controller;

import com.tender_management.tender_management_system.entity.BiddingModel;
import com.tender_management.tender_management_system.service.BiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
    @Autowired
    private BiddingService biddingService;

    @PostMapping("/add")
    public ResponseEntity<?> addBidding(@RequestHeader("Authorization") String header, @RequestBody BiddingModel biddingModel) {
        return biddingService.addBidding(header, biddingModel);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getBidDetails(@RequestHeader("Authorization") String header, @RequestParam("bidAmount") Double bidAmount) {
        return biddingService.getBidDetails(header, bidAmount);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBiddingStatus(@RequestHeader("Authorization") String header,@PathVariable Long id,@RequestBody BiddingModel biddingModel){
        return biddingService.updateBiddingStatus(header,id,biddingModel);
    }
}
