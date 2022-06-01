package newfeatures.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
# Java 内置 4 大核心函数式接口

- 消费型接口
  - Consumer<T>
- 供给型接口
  - Supplier<T>
- 函数型接口
  - Function<T,R>
- 断定型接口
  - Predicate<T>
- BiFunction<T,U,R>
- UnaryOperator<T>
- BinaryOperator<T,U>
- BiConsumer<T,U>
- BiPredicate<T,U>
- ToIntFunction<T>
- ToLongFunction<T>
- ToDoubleFunction<T>
- IntFunction<R>
- LongFunction<R>
- DoubleFunction<R>
 */
public class Lambda2Test {
    public void happyTime(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test1() {
        happyTime(
                500.0,
                money -> System.out.println("花了 " + money + " 块，真开心")
        );
    }

    // 根据给定的规则，过滤集合中的字符串
    // 此规则由 Predicate 的方法决定
    public ArrayList<String> filterString(List<String> strs, Predicate<String> pre) {
        ArrayList<String> filterStrs = new ArrayList<>();

        for (String str : strs) {
            if (pre.test(str)) {
                filterStrs.add(str);
            }
        }

        return filterStrs;
    }

    @Test
    public void test2() {
        ArrayList<String> filterCities = filterString(
                Arrays.asList(
                        "北京",
                        "天津",
                        "上海",
                        "广州",
                        "东京",
                        "南京"
                ),
                city -> city.contains("京")
        );

        System.out.println(filterCities);
    }
}
