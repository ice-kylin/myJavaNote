package objectoriented.exer.generalpractice.exer2;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank(10);

        bank.addCustomer("Jane", "Smith").getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withdraw(500);

        System.out.println("余额：" + bank.getCustomer(0).getAccount().getBalance());
    }
}
