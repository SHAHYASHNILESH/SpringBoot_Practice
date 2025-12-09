package com.tender_management.tender_management_system.repository;

import com.tender_management.tender_management_system.entity.BiddingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BiddingRepository extends JpaRepository<BiddingModel, Long> {
    @Query(value = "SELECT * FROM bidding_model WHERE bid_amount > :bidAmount", nativeQuery = true)
    List<BiddingModel> findByAmount(@Param("bidAmount") Double bidAmount);
}
