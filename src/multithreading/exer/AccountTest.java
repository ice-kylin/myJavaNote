package multithreading.exer;

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        ReentrantLock lock = new ReentrantLock();

        SaveMoneyThread t1 = new SaveMoneyThread(account, lock);
        SaveMoneyThread t2 = new SaveMoneyThread(account, lock);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}

class Account {
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void saveMoney(double money) {
        balance += money;
    }
}

class SaveMoneyThread extends Thread {
    private final Account account;
    private final ReentrantLock lock;

    public SaveMoneyThread(Account account, ReentrantLock lock) {
        this.account = account;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();

                System.out.println(getName() + " 向账户存了 " + 1000 + " 元");
                account.saveMoney(1000);
                System.out.println("账户余额为：" + account.getBalance() + " 元");
            } finally {
                lock.unlock();
            }
        }
    }
}
