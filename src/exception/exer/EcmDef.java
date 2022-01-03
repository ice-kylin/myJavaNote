package exception.exer;

public class EcmDef {
    public static double ecm(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException();
        }

        if (a < 0 || b < 0) {
            throw new EcDef("输入负数");
        }

        return a / b;
    }
}
