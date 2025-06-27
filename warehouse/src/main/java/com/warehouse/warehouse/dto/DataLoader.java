package com.warehouse.warehouse.dto;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.warehouse.warehouse.entity.UserInfo;
import com.warehouse.warehouse.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

	private final UserInfoRepository userInfoRepository;

	@Override
	public void run(String... args) throws Exception {

		// ---------------------- USERS ----------------------
		UserInfo user1 = new UserInfo(null, "jack", "pass_word", "ADMIN", null);
		UserInfo user2 = new UserInfo(null, "bob", "pass_word", "USER", null);
		UserInfo user3 = new UserInfo(null, "alice", "pass_word", "USER", null);

		userInfoRepository.saveAll(List.of(user1, user2, user3));

		System.out.println("✅ Sample data loaded: Users.");
	}
}