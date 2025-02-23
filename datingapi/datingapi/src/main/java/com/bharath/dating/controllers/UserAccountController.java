package com.bharath.dating.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bharath.dating.entities.Interest;
import com.bharath.dating.entities.UserAccount;
import com.bharath.dating.repos.InterestRepository;
import com.bharath.dating.repos.UserAccountRepository;

@RestController
@RequestMapping("/api")
public class UserAccountController {

	@Autowired
	private UserAccountRepository userRepo;

	@Autowired
	private InterestRepository interestRepo;

	@PostMapping("/users/register-user")
	public UserAccount registerUser(@RequestBody UserAccount userAccount) {
		try {
			return userRepo.save(userAccount);
		} catch (ConstraintViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}

	}

	@PostMapping("/interests/update")
	public Interest updateInterest(@RequestBody Interest interest) {
		UserAccount userAccount = userRepo.findById(interest.getUserAccountId()).get();
		interest.setUserAccount(userAccount);
		return interestRepo.save(interest);

	}

	@GetMapping("/users/get/all")
	public List<UserAccount> getUsers() {
		return userRepo.findAll();
	}

	@DeleteMapping("/users/delete/{interestId}")
	public void deleteInterest(@PathVariable("interestId") int id) {
		interestRepo.deleteById(id);
	}

	@GetMapping("/users/matches/{id}")
	public List<UserAccount> findMatches(@PathVariable("id") int id) {
		UserAccount userAccount = userRepo.findById(id).get();
		return userRepo.findMatches(userAccount.getAge(), userAccount.getCity(), userAccount.getCountry(),
				userAccount.getId());

	}

}
