package objectoriented.exer.generalpractice.exer1;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public Account setId(int id) {
        this.id = id;

        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Account setBalance(double balance) {
        this.balance = balance;

        return this;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Account setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;

        return this;
    }

    public Account withdraw(double amount) {
        if (this.getBalance() >= amount) {
            this.setBalance(this.getBalance() - amount);
            System.out.println("成功取出：" + amount + " 元");
        } else {
            System.out.println("💰 不够！");
        }

        return this;
    }

    public Account deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
        System.out.println("成功存入：" + amount + " 元");

        return this;
    }
}
