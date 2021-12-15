package objectoriented;

/*
# 方法参数的值传递机制

## 关于变量的赋值

- 如果变量是基本数据类型，此时赋值的是变量所保存的数据值
- 如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值

## 值传递

- 形参和实参的定义
  - 形参：方法定义时，声明的小括号内的参数
  - 实参：方法调用时，实际传递给形参的值
- 值传递机制的描述
  - 如果参数是基本数据类型，此时实参赋给形参的是实参真实存储的数据值
  - 如果参数是引用数据类型，此时实参赋给形参的是实参存储数据的地址值
 */
public class ParameterValueTransferMechanism {
    public static void main(String[] args) {
        ParameterValueTransferMechanism p = new ParameterValueTransferMechanism();
        int a = 233;
        int b = 666;
        String c = "Hello";
        String d = "World";

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("c = " + c + ", d = " + d);

        p.swapValues(a, b);
        p.swapValues(c, d);

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("c = " + c + ", d = " + d);
    }

    // 没用
    public void swapValues(int a, int b) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;

        System.out.println(".swapValues() 方法中：a = " + a + ", b = " + b);
    }

    // 没用
    public void swapValues(String a, String b) {
        String tmp;
        tmp = a;
        a = b;
        b = tmp;

        System.out.println(".swapValues() 方法中：a = " + a + ", b = " + b);
    }
}
