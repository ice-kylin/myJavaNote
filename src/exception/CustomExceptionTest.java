package exception;

import java.util.Scanner;

/*
# 自定义异常

1. 继承于现有的异常结构：`RuntimeException`、`Exception`
2. 提供全局常量：`serialVersionUID`
3. 提供重载的构造器
 */
public class CustomExceptionTest {
    public static void main(String[] args) {
        int a = 0;

        try {
            a = m1();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("a = " + a);
    }

    public static int m1() throws CustomException {
        Scanner scanner = new Scanner(System.in);
        int a;

        a = scanner.nextInt();

        if (a < 0) {
            throw new CustomException("传入值为负数");
        }

        return a;
    }
}

class CustomException extends RuntimeException {
    static final long serialVersionUID = -7023366690745766939L;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
