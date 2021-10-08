package typeofdata;

/*
# 字符串变量

- String
  - 属于引用数据类型
  - 定义 String 型变量，通常使用一对 `""`
  - String 可以和 8 种基本数据类型做运算
    - 运算只能是连接运算 `+`
    - 运算的结果仍然是 String 类型

 */
public class StringVariable {
    public static void main(String[] args) {
        String s1 = "Hello World!";
        System.out.println(s1);

        int i1 = 19;
        String s2 = "Age: ";
        String rst1 = s2 + i1; // +：连接运算
        System.out.println(rst1);

        boolean b1 = false;
        String s3 = "Gender: ";
        String rst2 = s3 + b1;
        System.out.println(rst2);

        // 练习1
        char c = 'a'; // 97
        int num = 10;
        String str = "Hello";
        System.out.println(c + num + str); // 107Hello
        System.out.println(c + str + num); // aHello10
        System.out.println(c + (str + num)); // aHello10
        System.out.println((c + num) + str); // 107Hello
        System.out.println(str + num + c); // Hello10a
    }
}
