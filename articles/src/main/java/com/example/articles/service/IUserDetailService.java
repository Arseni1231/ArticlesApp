package com.example.articles.service;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface IUserDetailService extends Serializable {
    Collection<? extends GrantedAuthority> getAuthorities();
    String getPassword();
    String getUsername();
    default boolean isAccountNonExpired() {
        return true;
    }
    default boolean isAccountNonLocked() {
        return true;
    }
    default boolean isCredentialsNonExpired() {
        return true;
    }
    default boolean isEnabled() {
        return true;
    }
}
