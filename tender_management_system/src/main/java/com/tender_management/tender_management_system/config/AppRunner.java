package com.tender_management.tender_management_system.config;

import com.tender_management.tender_management_system.entity.*;
import com.tender_management.tender_management_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Role role1 = new Role();
        role1.setRoleName("BIDDER");

        Role role2 = new Role();
        role2.setRoleName("APPROVER");

        Role saveRole1 = roleRepository.save(role1);
        Role saveRole2 = roleRepository.save(role2);

        UserInfo user1 = new UserInfo();
        user1.setEmail("bidder@gmail.com");
        user1.setPassword("1234");
        user1.setRole(saveRole1);

        UserInfo user2 = new UserInfo();
        user2.setEmail("approver@gmail.com");
        user2.setPassword("1234");
        user2.setRole(saveRole2);

        UserInfo user3 = new UserInfo();
        user3.setEmail("yash@gmail.com");
        user3.setPassword("1234");
        user3.setRole(saveRole2);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
