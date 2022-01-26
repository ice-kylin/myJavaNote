package commonclass.comparators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
# Java 比较器

## 说明

- Java 中的对象正常情况下只能进行比较 `==` 或 `!=`，不能使用 `>` 或 `<`
- 但是在开发场景中，我们需要对多个对象进行排序，言外之意就需要比较对象的大小
- 实现方法：使用连个接口中的任意一个
  - `Comparable`
    - 一旦指定，保证 `Comparable` 接口的实现类的对象在任何位置都可以比较大小
  - `Comparator`
    - 属于临时性的比较
 */
public class ComparatorsTest {
    /*
    ## `Comparable`（自然排序）

    - 像 `String`、包装类等实现了 `Comparable` 接口，重写了 `int compareTo(T o)` 方法，给出了比较两个对象大小的方式
    - 像 `String`、包装类重写 `int compareTo(T o)` 方法以后，进行了从小到大的排序
    - 重写 `int compareTo(T o)` 的规则
      - 如果当前对象 `this` 大于形参对象 `obj`，则返回正整数
      - 如果当前对象 `this` 小于形参对象 `obj`，则返回负整数
      - 如果当前对象 `this` 等于形参对象 `obj`，则返回零
    - 对于自定义类来说，如果需要排序，可以让自定义类实现 `Comparable` 接口，重写 `int compareTo(T o)` 方法
      - 在 `int compareTo(T o)` 方法中指明如何排序
     */
    @Test
    public void test1() {
        String[] strings = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k",
                "l", "z", "x", "c", "v", "b", "n", "m"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void test2() {
        Good[] goods = new Good[]{new Good("华为手机", 10000.02),
                new Good("b 苹果手机", 10000.01),
                new Good("a 苹果手机", 10000.01),
                new Good("小米手机", 2999),
                new Good("OPPO 手机", 4999)
        };

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /*
    ## `Comparator`（定制排序）

    - 背景
      - 当元素的类型没有实现 `Comparable` 接口而又不方便修改代码
      - 或者实现了 `Comparable` 接口的排序的排序规则不适合当前的操作
        - 那么可以考虑使用 `Comparator` 的对象进行排序
     */
    @Test
    public void test3() {
        String[] strings = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k",
                "l", "z", "x", "c", "v", "b", "n", "m"};

        Arrays.sort(strings, new Comparator() {
            // 按照字符串从大到小的顺序排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    return s2.compareTo(s1);
                } else {
                    throw new RuntimeException("传入的数据类型不一致：不是 String");
                }
            }
        });

        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void test4() {
        Good[] goods = new Good[]{new Good("华为手机", 10000.02),
                new Good("b 苹果手机", 10000.01),
                new Good("a 苹果手机", 10000.01),
                new Good("小米手机", 2999),
                new Good("小米手机", 3999),
                new Good("OPPO 手机", 4999)
        };

        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Good && o2 instanceof Good) {
                    Good g1 = (Good) o1;
                    Good g2 = (Good) o2;

                    int stringRst = g2.getName().compareTo(g1.getName());

                    if (stringRst != 0) {
                        return stringRst;
                    } else {
                        double doublePriceDifference = g1.getPrice() - g2.getPrice();
                        int intPriceDifference = (int) doublePriceDifference;

                        if (intPriceDifference != 0) {
                            return intPriceDifference;
                        } else {
                            if (doublePriceDifference > 0) {
                                return 1;
                            } else if (doublePriceDifference < 0) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                } else {
                    throw new RuntimeException("传入的数据类型不一致：不是商品");
                }
            }
        });

        for (Good good : goods) {
            System.out.println(good);
        }
    }
}

class Good implements Comparable {
    private String name;
    private double price;

    public Good() {
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // 指明商品比较大小的方式：按照价格从低到高排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Good) {
            Good good = (Good) o;

            double doublePriceDifference = this.price - good.price;
            int intPriceDifference = (int) doublePriceDifference;

            if (intPriceDifference != 0) {
                return intPriceDifference;
            } else {
                if (doublePriceDifference > 0) {
                    return 1;
                } else if (doublePriceDifference < 0) {
                    return -1;
                } else {
                    return this.name.compareTo(good.name);
                }
            }
        } else {
            throw new RuntimeException("传入的数据类型不一致：不是商品");
        }
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
