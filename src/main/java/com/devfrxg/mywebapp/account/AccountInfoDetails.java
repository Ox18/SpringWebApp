package com.devfrxg.mywebapp.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AccountInfoDetails implements UserDetails {

    private AccountInfo accountInfo;

    public AccountInfoDetails(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return accountInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return accountInfo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
