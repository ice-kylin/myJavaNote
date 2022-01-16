package multithreading;

public class BankTest {
    public static void main(String[] args) {

    }
}

class Bank {
    private static Bank instance;

    private Bank() {
    }

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }

        return instance;
    }
}
