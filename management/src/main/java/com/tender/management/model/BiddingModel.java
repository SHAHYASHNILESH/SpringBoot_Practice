package com.tender.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BiddingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private int biddingId;
	private final String projectName = "Metro Phase v 2024";
	private Double bidAmount;
	private Double yearsToComplete;
	private String dateOfBinding;
	private String status = "pending";
	private int bidderId;
}
