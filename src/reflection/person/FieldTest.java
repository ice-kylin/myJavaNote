package reflection.person;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
# 获取当前运行时类的属性结构
 */
public class FieldTest {
    /*
    ## 获取属性结构

    - `Field[] getFields()`：获取当前运行时类及其父类中声明为 `public` 访问权限的属性
    - `Field[] getDeclaredFields()`：获取当前运行时类中声明的所有属性（不包含父类中声明的属性）
     */
    @Test
    public void test1() {
        Class<?> personCls = Person.class;

        for (Field field : personCls.getFields()) {
            System.out.println(field);
        }

        System.out.println();

        for (Field declaredField : personCls.getDeclaredFields()) {
            System.out.println(declaredField);
        }
    }

    /*
    ## 获取属性的修饰符、数据类型、变量名
     */
    @Test
    public void test2() {
        Class<?> personCls = Person.class;

        for (Field declaredField : personCls.getDeclaredFields()) {
            // 权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println("修饰符：" + Modifier.toString(modifiers));

            // 数据类型
            Class<?> type = declaredField.getType();
            System.out.println("数据类型：" + type.getName());

            // 变量名
            String name = declaredField.getName();
            System.out.println("变量名：" + name);

            System.out.println("----- >8 -----");
        }
    }
}
