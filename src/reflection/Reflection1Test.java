package reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
# 反射

## 问题

- 通过直接 `new` 的方式或反射的方式都可以调用公共的构造器，开发中如何选择
  - 建议使用直接 `new` 的方式
  - 什么时候使用反射的方式：当需要使用到反射的特征 —— 动态性的时候
- 反射机制与面向对象中的封装性是否矛盾以及如何看待这两个技术
  - 不矛盾

## 关于 `java.lang.Class` 类的理解

- 类的加载过程
  1. 程序经过 `javac.exe` 命令后，会生成一个或多个字节码文件（`.class` 结尾）
  2. 接着使用 `java.exe` 命令对某个字节码文件进行解释运行
    - 相当于将某个字节码文件加载到内存中，此过程就称为类的加载
    - 加载到内存中的类，称为运行时类
    - 此运行时类，就作为 `Class` 的一个实例
- 换句话说，`Class` 的实例就对应着一个运行时类
 */
public class Reflection1Test {
    /*
    ## 反射之前

    - 在类外部，不可以通过类的对象调用其私有的内部结构
     */
    @Test
    public void test1() {
        // 1. 创建 Person 类的对象
        Person p1 = new Person("Isaac", 19);

        // 2. 调用对象指定的属性、方法
        p1.age = 10;
        p1.show();

        System.out.println(p1);
    }

    /*
    ## 反射之后

    - 通过反射，可以调用类的私有结构
      - 比如：私有的构造器、方法、属性
     */
    @Test
    public void test2() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        Class<Person> personClass = Person.class;
        // 1. 通过反射，创建 Person 类的对象
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person p1 = constructor.newInstance("Isaac", 19);

        System.out.println(p1);
        // 2. 通过反射，调用对象指定的属性、方法
        // 2.1 调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(p1, 20);

        System.out.println(p1);
        // 2.2 调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p1);

        System.out.println();

        // 3. 调用私有的结构
        // 3.1 调用私有的构造器
        Constructor<Person> constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person p2 = constructor1.newInstance("Isaac");

        System.out.println(p2);
        // 3.2 调用私有的属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2, "icekylin");

        System.out.println(p2);
        // 3.3 调用私有的方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);

        String nation = (String) showNation.invoke(p2, "China");
        System.out.println(nation);
    }

    /*
    ## `Class` 实例可以是哪些结构

    - class
      - 外部类
      - 成员
        - 成员内部类
        - 成员外部类
      - 局部内部类
      - 匿名内部类
    - interface：接口
    - []：数组
    - enum：枚举
    - annotation：注解
    - primitive type：基本数据类型
    - void
     */
    @Test
    public void test3() {
        System.out.println(Object.class);
        System.out.println(Comparable.class);
        System.out.println(String[].class);
        System.out.println(int[][].class);
        System.out.println(ElementType.class);
        System.out.println(Override.class);
        System.out.println(int.class);
        System.out.println(void.class);
        System.out.println(Class.class);
    }
}
