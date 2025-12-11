package com.cart.problem.config;

import com.cart.problem.models.UserInfo;
import com.cart.problem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found!!"));
        return new UserInfoUserDetails(userInfo);
    }
}
