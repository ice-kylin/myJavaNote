package objectoriented.exer;

public class OverloadExer {
    public static void main(String[] args) {
        OverloadExer oe = new OverloadExer();

        oe.mOL(2);
        oe.mOL(2, 3);
        oe.mOL("Hello");

        System.out.println(oe.max(666, 233));
        System.out.println(oe.max(233.33, 666.66));
        System.out.println(oe.max(233.33, 666.666, 123.456));
    }

    public void mOL(int num) {
        System.out.println("num**2 = " + (int) Math.pow(num, 2));
    }

    public void mOL(int num1, int num2) {
        System.out.println("num1 * num2 = " + num1 * num2);
    }

    public void mOL(String str) {
        System.out.println("str = " + str);
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public double max(double a, double b) {
        return a > b ? a : b;
    }

    public double max(double a, double b, double c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }
}
