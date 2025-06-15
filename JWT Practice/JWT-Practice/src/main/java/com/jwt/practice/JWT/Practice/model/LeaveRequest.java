package com.jwt.practice.JWT.Practice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LeaveRequest {

	private String category;
	private int noOfDays;
	private LocalDate appliedOn;
	private String description;

}
