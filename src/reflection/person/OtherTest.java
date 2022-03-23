package reflection.person;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/*
# 获取当前运行时类的其它结构
 */
public class OtherTest {
    /*
    ## 获取构造器结构

    - `Constructor<?>[] getConstructors()`：获取当前运行时类中声明为 `public` 的构造器
     */
    @Test
    public void test1() {
        Class<?> personClass = Person.class;

        for (Constructor<?> constructor : personClass.getConstructors()) {
            System.out.println(constructor);
        }

        System.out.println();

        for (Constructor<?> declaredConstructor : personClass.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
    }

    /*
    ## 获取运行时类的父类

    - `native Class<? super T> getSuperclass()`：获取运行时类的父类
    - `Type getGenericSuperclass()`：获取运行时类的带泛型的父类
     */
    @Test
    public void test2() {
        Class<?> personClass = Person.class;
        System.out.println(personClass.getSuperclass());
        System.out.println(personClass.getGenericSuperclass());
    }

    /*
    ## 获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test3() {
        /*
        Class<?> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        for (Type actualTypeArgument : parameterizedType.getActualTypeArguments()) {
            System.out.println(actualTypeArgument.getTypeName());
            System.out.println(((Class<?>) actualTypeArgument).getName());
        }
         */
    }

    /*
    ## 获取运行时类实现的接口
     */
    @Test
    public void test4() {
        Class<?> personClass = Person.class;

        for (Class<?> personClassInterface : personClass.getInterfaces()) {
            System.out.println(personClassInterface);
        }

        System.out.println();

        // 获取运行时类的父类实现的接口
        for (Class<?> anInterface : personClass.getSuperclass().getInterfaces()) {
            System.out.println(anInterface);
        }
    }

    /*
    ## 获取运行时类所在的包
     */
    @Test
    public void test5() {
        Class<?> personClass = Person.class;

        Package personClassPackage = personClass.getPackage();
        System.out.println(personClassPackage);
    }

    /*
    ## 获取运行时类声明的注解
     */
    @Test
    public void test6() {
        Class<?> personClass = Person.class;

        for (Annotation personClassAnnotation : personClass.getAnnotations()) {
            System.out.println(personClassAnnotation);
        }
    }
}
