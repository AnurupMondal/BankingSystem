package main.accounts;
import main.transactions.Transaction;

public class BankAccount extends Transaction {
    private final String accountHolder;
    private final String accountNumber;
    protected double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() { return accountHolder; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal or insufficient balance.");
        }
    }
}