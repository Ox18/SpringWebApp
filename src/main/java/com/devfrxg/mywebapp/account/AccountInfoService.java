package com.devfrxg.mywebapp.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService implements UserDetailsService {

    @Autowired
    private AccountInfoDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountInfo account = dao.findAccountByUsername(username);
        if(account == null){
            throw new UsernameNotFoundException("This user does not exist");
        }

        return new AccountInfoDetails(account);
    }
}
