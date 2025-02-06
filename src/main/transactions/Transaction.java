package main.transactions;

public abstract class Transaction {
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
}