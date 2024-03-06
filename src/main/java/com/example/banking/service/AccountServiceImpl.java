package com.example.banking.service;

import com.example.banking.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final Map<String, Account> accountMap;

    public AccountServiceImpl() {
        this.accountMap = new HashMap<>();
    }

    @Override
    public Account createAccount(Account account) {
        accountMap.put(account.getAccountId(), account);
        return account;
    }

    @Override
    public Account getAccountById(String accountId) {
        return accountMap.get(accountId);
    }

    @Override
    public void deleteAccount(String accountId) {
        accountMap.remove(accountId);
    }

    @Override
    public Account updateAccount(Account account) {
        if (accountMap.containsKey(account.getAccountId())) {
            accountMap.put(account.getAccountId(), account);
            return account;
        }
        return null; // Return null if account not found
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(accountMap.values());
    }
}
