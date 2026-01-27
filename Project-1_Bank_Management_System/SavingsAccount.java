package com.bankmanagement;

public class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }
}
