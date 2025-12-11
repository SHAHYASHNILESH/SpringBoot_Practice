package com.cart.problem.config;

import com.cart.problem.models.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInfoUserDetails implements UserDetails {
    private UserInfo userInfo;

    public UserInfo getUserInfo(){
        return userInfo;
    }

    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(UserInfo userInfo){
        this.name=userInfo.getUsername();
        this.password=userInfo.getPassword();
        this.authorities= Stream.of(userInfo.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}
