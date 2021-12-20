package objectoriented.exer.generalpractice.exer1;

public class CustomerTest {
    public static void main(String[] args) {
        Customer janeSmith = new Customer("Jane", "Smith");
        janeSmith.setAccount(new Account(1000, 2000, 1.23));

        janeSmith.getAccount().deposit(100).withdraw(960).withdraw(2000);

        System.out.println("用户 [" + janeSmith.getFirstName() + ", " + janeSmith.getLastName() + "] 有一个账户：");
        System.out.println("Id 为：" + janeSmith.getAccount().getId());
        System.out.println("年利率为：" + janeSmith.getAccount().getAnnualInterestRate() + "%");
        System.out.println("余额为：" + janeSmith.getAccount().getBalance() + " 元");
    }
}
