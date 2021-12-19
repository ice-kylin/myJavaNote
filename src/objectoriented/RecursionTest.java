package objectoriented;

/*
# 递归

- 递归方法：一个方法体内调用了它自身
- 方法递归包含了一种隐式的循环，它会重复的执行某段代码，但这种重复执行无需循环控制
- 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环
 */
public class RecursionTest {
    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();

        System.out.println("test.getSum(100) = " + test.getSum(100));
        System.out.println("test.getF(10) = " + test.getF(10));
    }

    public int getSum(int i) {
        if (i > 0) {
            return i + getSum(i - 1);
        } else return i;
    }

    public int getF(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 4;
        } else {
            return 2 * getF(i - 1) + getF(i - 2);
        }
    }
}
