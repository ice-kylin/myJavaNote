package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
# 反射

- 通过直接 `new` 的方式或反射的方式都可以调用公共的构造器，开发中如何选择
  - 建议使用直接 `new` 的方式
  - 什么时候使用反射的方式：当需要使用到反射的特征 —— 动态性的时候
- 反射机制与面向对象中的封装性是否矛盾以及如何看待这两个技术
  - 不矛盾
 */
public class ReflectionTest {
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
}
