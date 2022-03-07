package reflection.person;

import org.junit.Test;

import java.lang.reflect.Method;

/*
# 获取当前运行时类的方法结构
 */
public class MethodTest {
    /*
    ## 获取方法结构

    - `Method[] getMethods()`：获取当前运行时类及其所有的父类中声明为 `public` 权限的方法
    - `Method[] getDeclaredMethods()`：获取当前运行时类中声明的所有方法（不包含父类中声明的方法）
     */
    @Test
    public void test1() {
        Class<?> personCls = Person.class;

        for (Method method : personCls.getMethods()) {
            System.out.println(method);
        }

        System.out.println();

        for (Method declaredMethod : personCls.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }
    }

    /*
    ```
    @注解
    修饰符 返回值类型 方法名(参数类型1 形参名1, ...) throws 异常1, ... {
    }
    ```
     */
    @Test
    public void test2() {
        // 注解

        // 修饰符

        // 返回值类型

        // 方法名

        // 形参列表

        // 抛出的异常
    }
}
