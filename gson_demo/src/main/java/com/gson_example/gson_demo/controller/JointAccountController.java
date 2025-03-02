package com.gson_example.gson_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gson_example.gson_demo.entity.JointAccount;
import com.gson_example.gson_demo.service.JointAccountService;

@RestController
public class JointAccountController {

	@Autowired
	private JointAccountService jointAccountService;

	@GetMapping("/joint-account/{leadId}")
	public String getJointAccountById(@PathVariable Long leadId) {
		return jointAccountService.getJointAccountById(leadId);
	}

	@PostMapping("/joint-account")
	@ResponseStatus(value = HttpStatus.CREATED)
	public JointAccount createJointAccount(@RequestBody JointAccount jointAccount) {

		return jointAccountService.createJointAccount(jointAccount);
	}
}
