package reflection;

import org.junit.Test;
import reflection.person.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
# 调用运行时类中指定的结构：属性、方法、构造器
 */
public class Reflection2Test {
    // - 操作运行时类中指定的属性
    @Test
    public void test1() throws
            NoSuchFieldException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<?> personClass = Person.class;

        // 创建运行时类的对象
        Object person = personClass
                .getDeclaredConstructor()
                .newInstance();

        // 1. getDeclaredField(String name)：获取运行时类中指定变量名的属性
        Field field = personClass.getDeclaredField("pid");

        // 2. 保证当前属性是可访问的
        field.setAccessible(true);
        /*
        - 设置当前属性的值
          - `set()`
            - 参数 1：指明设置哪个对象的属性
            - 参数 2：将此属性值设置为多少
         */
        field.set(person, 1001); // 3. 获取、设置指定对象的此属性值

        // 获取当前属性的值
        System.out.println(field.get(person));
    }

    // - 操作运行时类中指定的方法
    @Test
    public void test2() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<?> personClass = Person.class;

        // 创建运行时类的对象
        Object person = personClass
                .getDeclaredConstructor()
                .newInstance();

        // 1. getDeclaredMethod()：获取指定的某个方法
        Method show = personClass.getDeclaredMethod(
                "show", // 参数 1：指明获取的方法的名称
                String.class // 参数 2：指明获取的方法的形参列表
        );

        // 2. 保证当前方法是可访问的
        show.setAccessible(true);

        // 3. 调用方法
        Object returnValue = show.invoke(
                person, // 参数 1：方法的调用者
                "CHN" // 参数 2：给方法形参赋值的实参
        );

        System.out.println(returnValue);
    }

    @Test
    public void test3() throws
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException {
        Class<?> personClass = Person.class;

        Method showDesc = personClass
                .getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        // 如果调用的运行时类中的方法没有返回值，则此 invoke() 方法返回 null
        Object returnValue = showDesc.invoke(personClass);

        System.out.println(returnValue);
    }

    // - 调用运行时类中的指定的构造器
    @Test
    public void test4() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Class<?> personClass = Person.class;

        // 1. 获取指定的构造器
        Constructor<?> constructor = personClass.getDeclaredConstructor(
                String.class // 参数：指明构造器的参数列表
        );

        // 2. 保证此构造器是可访问的
        constructor.setAccessible(true);

        // 3. 调用此构造器创建运行时类的对象
        Person<?> person = (Person<?>) constructor.newInstance("Tom");

        System.out.println(person);
    }
}
