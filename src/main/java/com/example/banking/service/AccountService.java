package com.example.banking.service;

import com.example.banking.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountById(String accountId);
    void deleteAccount(String accountId);
    Account updateAccount(Account account); // Define updateAccount method
    List<Account> getAllAccounts(); // Define getAllAccounts method
}
