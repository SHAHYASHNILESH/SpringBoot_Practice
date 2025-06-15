package com.jwt.practice.JWT.Practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//STEP : 10 - Create LoginRequest for Login Controller

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginRequest {

	private String email;
	private String password;

}
