package newfeatures.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
# 构造器引用

- 和方法引用类似
  - 函数式接口的抽象方法的形参列表和构造器的形参列表一致
  - 抽象方法的返回值类型即为构造器所属的类的类型

# 数组引用
 */
public class ConstructorRefTest {
    // 构造器引用
    @Test
    public void test1() {
        Supplier<Customer> supplier = Customer::new;
        System.out.println(supplier.get());
    }

    @Test
    public void test2() {
        Function<Integer, Customer> f = Customer::new;
        System.out.println(f.apply(1001));
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Customer> f = Customer::new;
        System.out.println(f.apply(1002, "Dupi"));
    }

    // 数组引用
    @Test
    public void test4() {
        Function<Integer, String[]> f = String[]::new;
        System.out.println(
                Arrays.toString(
                        f.apply(5)
                )
        );
    }
}
