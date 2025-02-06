package main.accounts;

public class CurrentAccount extends BankAccount {
    private final double overdraftLimit;

    public CurrentAccount(String accountHolder, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolder, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. Remaining Balance: " + balance);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }
}
