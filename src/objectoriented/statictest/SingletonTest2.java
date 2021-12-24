package objectoriented.statictest;

public class SingletonTest2 {
    public static void main(String[] args) {
        Order o1 = Order.getInstance();
        Order o2 = Order.getInstance();

        System.out.println(o1 == o2);
    }
}

// 懒汉式
class Order {
    private static Order instance;

    private Order() {
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
