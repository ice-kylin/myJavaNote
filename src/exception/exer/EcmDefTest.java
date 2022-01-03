package exception.exer;

import java.util.Scanner;

public class EcmDefTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arg1;
        String arg2;
        double rst;
        double num1;
        double num2;
        boolean first = true;

        while (true) {
            try {
                if (first) {
                    arg1 = args[0];
                    arg2 = args[1];
                } else {
                    System.out.print("请输入第一个数：");
                    arg1 = scanner.nextLine();
                    System.out.print("请输入第二个数：");
                    arg2 = scanner.nextLine();
                }

                num1 = Double.parseDouble(arg1);
                num2 = Double.parseDouble(arg2);

                rst = EcmDef.ecm(num1, num2);

                break;
            } catch (NumberFormatException nfe) {
                System.out.println("输入参数非法！请重试：");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("缺少命令行参数！请重试：");
            } catch (ArithmeticException e) {
                System.out.println("不能除以零！请重试：");
            } catch (EcDef e) {
                System.out.println(e.getMessage());
            }

            first = false;
        }

        System.out.println("结果为：" + rst);
    }
}
