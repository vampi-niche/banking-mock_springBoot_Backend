package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable String accountId) {
        return accountService.getAccountById(accountId);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable String accountId, @RequestBody Account account) {
        // Assuming account ID is not allowed to change
        account.setAccountId(accountId);
        return accountService.updateAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // You can add more methods as needed
}
