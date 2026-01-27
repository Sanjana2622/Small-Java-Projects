package com.bankmanagement;
import java.io.*;
import java.util.*;
public class Bank {

    private ArrayList<Account> accounts;
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "accounts.txt";

    public Bank() {
        accounts = loadAccounts();
    }

    public void createAccount() {
        try {
            System.out.print("Account Number: ");
            int accNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.print("1. Savings  2. Current : ");
            int type = sc.nextInt();

            Account acc;
            if (type == 1)
                acc = new SavingsAccount(accNo, name, balance);
            else
                acc = new CurrentAccount(accNo, name, balance);

            accounts.add(acc);
            saveAccounts();
            System.out.println("Account created successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }
    }

    private Account findAccount(int accNo) {
        for (Account acc : accounts)
            if (acc.getAccountNumber() == accNo)
                return acc;
        return null;
    }

    public void depositMoney() {
        try {
            System.out.print("Account Number: ");
            int accNo = sc.nextInt();
            Account acc = findAccount(accNo);

            if (acc == null) {
                System.out.println("Account not found");
                return;
            }

            System.out.print("Amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
            saveAccounts();
            System.out.println("Deposit successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawMoney() {
        try {
            System.out.print("Account Number: ");
            int accNo = sc.nextInt();
            Account acc = findAccount(accNo);

            if (acc == null) {
                System.out.println("Account not found");
                return;
            }

            System.out.print("Amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
            saveAccounts();
            System.out.println("Withdrawal successful");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllAccounts() {
        for (Account acc : accounts) {
            System.out.println("----------------");
            acc.display();
        }
    }

    // ---------- FILE HANDLING ----------
    private void saveAccounts() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    private ArrayList<Account> loadAccounts() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Account>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
