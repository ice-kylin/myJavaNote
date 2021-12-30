package objectoriented.innerclass;

/*
# 局部内部类

## 注意

- 在局部内部类的方法中，如果调用局部内部类所声明的方法中的局部变量的话，要求此局部变量声明为 `final` 的
  - JDK 7 及之前版本：要求此局部变量显式地声明为 `final` 的
  - JDK 8 及之后版本：可以省略 `final` 声明
 */
public class LocalInnerClassTest {
    public static void main(String[] args) {
        LocalInnerClassTest l = new LocalInnerClassTest();
        l.m1();
    }

    public void m1() {
        int num = 1;

        class InnerClass {
            public void m2() {
                System.out.println("num = " + num);
                // num = 2;
            }
        }

        InnerClass i = new InnerClass();
        i.m2();
    }
}
