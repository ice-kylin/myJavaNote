package objectoriented.exer.equals;

public class OrderTest {
    public static void main(String[] args) {
        Order o1 = new Order(1, "Issac");
        Order o2 = new Order(1, "Issac");
        Order o3 = new Order(2, "icekylin");

        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(o1.equals(null));
        System.out.println(o1.equals("SB"));
    }
}
