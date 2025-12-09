package com.tender_management.tender_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BiddingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int biddingId;
    private final String projectName = "Metro Phase V 2024";
    private Double bidAmount;
    private Double yearsToComplete;
    private String dateOfBidding;
    private String status = "pending";
    @Column(unique = true)
    private int bidderId;
}
