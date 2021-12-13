package objectoriented;

/*
# 匿名对象

- 创建的对象没有显式的赋给一个变量名，即为匿名对象
- 匿名对象只能调用一次
 */
public class AnonymousObject {
    public static void main(String[] args) {
        new Phone().sendEmail();
        new Phone().playGame();
        System.out.println(new Phone().price);
    }
}

class Phone {
    double price;

    public void sendEmail() {
        System.out.println("发送邮件");
    }

    public void playGame() {
        System.out.println("玩游戏🎮");
    }
}
