package com.tender.management.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tender.management.model.RoleModel;
import com.tender.management.model.UserModel;
import com.tender.management.repo.RoleRepository;
import com.tender.management.repo.UserRepository;

@Component
@SuppressWarnings("unused")
public class DataLoader implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	public DataLoader(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;

	}

	@Override
	public void run(String... args) {
		// Create BIDDER role
		RoleModel bidderRole = roleRepository.findByRoleName("BIDDER")
				.orElseGet(() -> roleRepository.save(new RoleModel(null, "BIDDER")));

		// Create APPROVER role
		RoleModel approverRole = roleRepository.findByRoleName("APPROVER")
				.orElseGet(() -> roleRepository.save(new RoleModel(null, "APPROVER")));

		// Create BIDDER user
		UserModel bidder = new UserModel();
		bidder.setUsername("bidder");
		bidder.setCompanyName("Bidder Co.");
		bidder.setEmail("bidder@example.com");
		bidder.setPassword("bidder123");
		bidder.setRole(bidderRole);
		userRepository.save(bidder);

		// Create APPROVER user
		UserModel approver = new UserModel();
		approver.setUsername("approver");
		approver.setCompanyName("Approver Inc.");
		approver.setEmail("approver@example.com");
		approver.setPassword("approver123");
		approver.setRole(approverRole);
		userRepository.save(approver);

		System.out.println("Data loaded...");
	}
}
