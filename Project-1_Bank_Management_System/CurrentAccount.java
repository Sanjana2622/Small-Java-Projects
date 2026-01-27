package com.bankmanagement;

public class CurrentAccount extends Account {

    private static final double MIN_BALANCE = 1000;

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE)
            throw new IllegalArgumentException("Minimum balance of 1000 required");
        super.withdraw(amount);
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }
}
