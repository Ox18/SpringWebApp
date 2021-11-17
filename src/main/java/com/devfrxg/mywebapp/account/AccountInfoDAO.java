package com.devfrxg.mywebapp.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoDAO extends JpaRepository<AccountInfo, Integer> {
    AccountInfo findAccountByUsername(String username);
}
