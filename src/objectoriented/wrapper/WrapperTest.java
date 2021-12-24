package objectoriented.wrapper;

import org.junit.Test;

/*
# 包装类

- 针对八种基本数据类型定义相应的引用数据类型 —— 包装类（引用类），使得基本数据类型的变量具有类的特征
- 有了类的特点，就可以调用类中的方法，Java 才是真正地面向对象
- 基本数据类型 -> 引用数据类型
  - byte -> Byte
  - short -> Short
  - int -> Integer
  - long -> Long
  - float -> Float
  - double -> Double
    - 父类都是 `Number`
  - boolean -> Boolean
  - char -> Character
- 掌握的：基本数据类型、包装类、String 三者之间的相互转换
 */
public class WrapperTest {
    // 基本数据类型 -> 包装类：调用包装类的构造器
    @Test
    public void test1() {
        // int
        int i1 = 233;
        Integer in1 = new Integer(i1);
        Integer in2 = new Integer("666");

        System.out.println(in1);
        System.out.println(in2);

        System.out.println();

        // float
        Float f1 = new Float(233.33f);
        Float f2 = new Float("666.666");

        System.out.println(f1);
        System.out.println(f2);

        System.out.println();

        // boolean
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("TrUe");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    // 包装类 -> 基本数据类型：调用包装类 `Xxx` 的 `.xxxValue()` 方法
    @Test
    public void test2() {
        // int
        Integer in1 = new Integer(233);
        int i1 = in1.intValue();

        System.out.println(i1);

        // float
        Float fl1 = new Float(233.333);
        float f1 = fl1.floatValue();

        System.out.println(f1);
    }

    /*
    # JDK 5.0 新特性：自动装箱 与 自动拆箱

    - 自动装箱：基本数据类型 -> 包装类
    - 自动拆箱：包装类 -> 基本数据类型
     */
    @Test
    public void test3() {
        // 自动装箱
        Integer in1 = 123;
        Float fl1 = 233.333f;

        System.out.println(in1);
        System.out.println(fl1);

        // 自动拆箱
        int i1 = in1;
        float f1 = fl1;
        double d1 = fl1;

        System.out.println(i1);
        System.out.println(f1);
        System.out.println(d1);
    }

    // 基本数据类型、包装类 -> `String` 类型
    @Test
    public void test4() {
        int i1 = 233;
        boolean b1 = true;

        // 方式一：连接运算
        System.out.println(i1 + "");
        System.out.println(b1 + "");

        System.out.println();

        // 方式二：调用 `String` 的 `.valueOf(Xxx xxx)`
        System.out.println(String.valueOf(i1));
        System.out.println(String.valueOf(b1));
    }

    // `String` -> 基本数据类型、包装类：调用包装类的 `.parseXxx(String s)`
    @Test
    public void test5() {
        String s1 = "233";
        String s2 = "TrUe";

        //
        int i1 = Integer.parseInt(s1);
        boolean b1 = Boolean.parseBoolean(s2);

        System.out.println(i1);
        System.out.println(b1);
    }

    /*
    # 注意点

    - `Integer` 内部定义了 `IntegerCache` 结构，`IntegerCache` 中定义了 `Integer[]`
    - 保存了从 `-128` ~ `127` 范围的整数
    - 如果使用自动装箱的方式，给 `Integer` 赋值的范围在 `-128` ~ `127` 范围内时
    - 可以直接使用数组中的元素，不用再去 `new` 了，从而提高了效率
     */
    @Test
    public void test6() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);

        Integer i3 = 1;
        Integer i4 = 1;
        System.out.println(i3 == i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6);
    }
}
