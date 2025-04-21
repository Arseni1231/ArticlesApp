package com.example.articles.models;

import com.example.articles.service.IUserDetailService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.articles.models.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetails implements IUserDetailService {

    private final User user;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }



    public static UserDetails build(User user) {
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole().name()));
        return new UserDetails(user, authorities);
    }
}
