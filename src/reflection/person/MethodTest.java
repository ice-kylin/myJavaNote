package reflection.person;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
    ## 获取运行时类的方法的内部结构

    ```
    @注解
    修饰符 返回值类型 方法名(参数类型1 形参名1, ...) throws 异常1, ... {
    }
    ```
     */
    @Test
    public void test2() {
        Class<?> personClass = Person.class;

        for (Method declaredMethod : personClass.getDeclaredMethods()) {
            // 注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            if (annotations != null) {
                for (Annotation annotation : annotations) {
                    System.out.println(annotation);
                }
            }

            // 修饰符
            int modifiers = declaredMethod.getModifiers();
            if (modifiers != 0) {
                System.out.print(Modifier.toString(modifiers) + " ");
            }

            // 返回值类型
            System.out.print(declaredMethod.getReturnType().getName() + " ");

            // 方法名
            System.out.print(declaredMethod.getName());

            // 形参列表
            System.out.print("(");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getName() + " arg_" + (i + 1));

                if (i != parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")");

            // 抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print(" throws ");
            }
            for (int i = 0; i < exceptionTypes.length; i++) {
                System.out.print(exceptionTypes[i].getName());

                if (i != exceptionTypes.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print(" {...}\n\n");
        }
    }
}
