package objectoriented;

public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest ma = new OverLoadTest();

        System.out.println(ma.addNums(1, 2));
        System.out.println(ma.addNums(1.5, 2.5));
        System.out.println(ma.addNums(1, 2, 3));
    }

    public int addNums(int a, int b) {
        return a + b;
    }

    public int addNums(int a, int b, int c) {
        return a + b + c;
    }

    public double addNums(double a, double b) {
        return a + b;
    }
}
