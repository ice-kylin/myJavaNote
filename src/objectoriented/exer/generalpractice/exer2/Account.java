package objectoriented.exer.generalpractice.exer2;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public Account deposit(double amount) {
        balance += amount;

        return this;
    }

    public Account withdraw(double amount) {
        if (getBalance() > amount) {
            balance -= amount;
        } else {
            System.out.println("余额不足...");
        }

        return this;
    }
}
