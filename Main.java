package com.bankmanagement;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Display All");
            System.out.println("5.Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> bank.createAccount();
                case 2 -> bank.depositMoney();
                case 3 -> bank.withdrawMoney();
                case 4 -> bank.displayAllAccounts();
                case 5 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}
