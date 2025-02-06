package main.Bank;

import main.accounts.*;
import java.util.*;

public class Bank {
    private static final ArrayList<BankAccount> accounts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Banking System");
        while (true) {
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Show Accounts\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> showAccounts();
                case 5 -> {
                    System.out.println("Thank you for using our Banking System!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Create a new account
    private static void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        System.out.println("Select Account Type: 1. Savings 2. Current");
        int type = scanner.nextInt();

        if (type == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double rate = scanner.nextDouble();
            accounts.add(new SavingsAccount(name, accNumber, balance, rate));
        } else if (type == 2) {
            System.out.print("Enter Overdraft Limit: ");
            double overdraft = scanner.nextDouble();
            accounts.add(new CurrentAccount(name, accNumber, balance, overdraft));
        } else {
            System.out.println("Invalid account type selection.");
            return;
        }
        System.out.println("✅ Account created successfully!");
    }

    // Deposit money into an account
    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();

        BankAccount account = findAccount(accNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Amount to Deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money from an account
    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.next();

        BankAccount account = findAccount(accNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Amount to Withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Display all accounts
    private static void showAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n🔹 List of Accounts:");
        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getAccountHolder() +
                    ", Account Number: " + acc.getAccountNumber() +
                    ", Balance: $" + acc.getBalance());
        }
    }

    // Helper method to find an account by number
    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}