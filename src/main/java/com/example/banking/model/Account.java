package com.example.banking.model;

public class Account {
    private String accountId;
    private double balance;

    // Constructor
    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    // Getters and setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
