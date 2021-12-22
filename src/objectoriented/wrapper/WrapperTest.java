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
}
