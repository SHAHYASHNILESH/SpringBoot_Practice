package com.bharath.dating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.dating.controllers.UserAccountController;
import com.bharath.dating.entities.Interest;
import com.bharath.dating.entities.UserAccount;
import com.bharath.dating.repos.InterestRepository;
import com.bharath.dating.repos.UserAccountRepository;

@SpringBootTest
class DatingapiApplicationTests {

	@Mock
	private UserAccountRepository userRepo;

	@Mock
	private InterestRepository interestRepo;

	@InjectMocks
	private UserAccountController controller;

	@Test
	public void shouldRegisterUser() {

		UserAccount userAccount = new UserAccount();
		UserAccount savedUserAccount = new UserAccount();

		savedUserAccount.setId(123);

		when(userRepo.save(userAccount)).thenReturn(savedUserAccount);

		UserAccount registerUser = controller.registerUser(userAccount);

		assertNotNull(registerUser);
		assertEquals(123, registerUser.getId());
		verify(userRepo).save(userAccount);

	}

	@Test
	public void shouldUpdateInterest() {

		UserAccount userAccount = new UserAccount();
		Interest interest = new Interest();

		interest.setUserAccountId(123);
		when(userRepo.findById(123)).thenReturn(Optional.of(userAccount));

		Interest savedInterest = new Interest();
		savedInterest.setUserAccountId(123);
		when(interestRepo.save(interest)).thenReturn(savedInterest);

		Interest updatedInterest = controller.updateInterest(interest);

		assertNotNull(updatedInterest);
		assertEquals(123, updatedInterest.getUserAccountId());
		verify(userRepo).findById(123);
		verify(interestRepo).save(interest);

	}

	@Test
	public void shouldFetchAllUsers() {

		List<UserAccount> users = new ArrayList<>();
		users.add(new UserAccount());
		users.add(new UserAccount());
		users.add(new UserAccount());

		when(userRepo.findAll()).thenReturn(users);

		List<UserAccount> fetchedUsers = controller.getUsers();

		assertNotNull(fetchedUsers);
		assertEquals(3, fetchedUsers.size());
		verify(userRepo).findAll();

	}

	@Test
	public void shouldDeleteInterest() {

		Interest interest = new Interest();
		interest.setId(123);

		doNothing().when(interestRepo).deleteById(123);

		controller.deleteInterest(123);

		verify(interestRepo).deleteById(123);

	}

	@Test
	public void shouldFetchMatches() {

		UserAccount userAccount = new UserAccount();
		userAccount.setId(123);
		userAccount.setAge(20);
		userAccount.setCity("Mumbai");
		userAccount.setCountry("India");

		when(userRepo.findById(123)).thenReturn(Optional.of(userAccount));

		List<UserAccount> matches = new ArrayList<>();
		matches.add(new UserAccount());
		matches.add(new UserAccount());
		matches.add(new UserAccount());

		when(userRepo.findMatches(20, "Mumbai", "India", 123)).thenReturn(matches);

		List<UserAccount> fetchedMatches = controller.findMatches(123);

		assertNotNull(fetchedMatches);
		assertEquals(3, fetchedMatches.size());

		verify(userRepo).findById(123);
		verify(userRepo).findMatches(20, "Mumbai", "India", 123);

	}
}
