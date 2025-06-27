package com.tender.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tender.management.model.BiddingModel;

public interface BiddingRepository extends JpaRepository<BiddingModel, Long> {

}
