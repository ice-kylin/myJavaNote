package objectoriented.exer.interfacetest;

public class InterfaceTest {
    public static void main(String[] args) {
        CompareableCircle c1 = new CompareableCircle(2);
        CompareableCircle c2 = new CompareableCircle(6);

        System.out.println(c1.compareTo(c2));
    }
}
