package operator.exer;

public class TheNumberInEachDigit {
    public static void main(String[] args) {
        int num = 123456;
        int totalDigit = 0;
        int digit = 1;

        // 获取总位数
        while (num % Math.pow(10, totalDigit) != num) {
            totalDigit++;
        }
        // System.out.println("totalDigit = " + totalDigit);

        // 获取各个位数上的数
        while (digit <= totalDigit) {
            System.out.println(digit + " 位数上的数：" + num % (int) Math.pow(10, digit) / (int) Math.pow(10, digit - 1));
            digit++;
        }
    }
}
