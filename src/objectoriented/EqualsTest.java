package objectoriented;

import java.util.Objects;

/*
# `==` 和 `.equals()` 的区别

## `==`：运算符

- 可以使用在基本数据类型和引用数据类型变量中
- 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等（不一定类型要相同）
- 如果比较的是引用数据类型：比较两个对象地址值是否相同，即两个引用是否指向两个同一个对象实体
- 补充：`==` 符号使用时，必须保证符号左右两边的变量类型一致

## `.equals()`：方法

- 是一个方法而不是运算符
- 只能适用于引用数据类型
- `Object` 类中定义的 `equals()` 和 `==` 的作用是相同的：比较两个对象的地址值是否相同
- 像 `String`、`Date`、`File`、包装类等都重写了 `Object` 类中定义的 `equals()` 方法
  - 重写以后比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同
- 通常情况下自定义的类如果使用 `.equals()` 的话，也通常是比较两个对象的“实体内容”是否相同
  - 那么就需要对 `Object` 类中的 `equals()` 进行重写

### 重写 `.equals()` 方法的原则

- 对称性
  - 如果 `x.equals(y)` 返回是 `true`，那么 `y.equals(x)` 也应该返回是 `true`
- 自反性
  - `x.equals(y)` 必须返回是 `true`
- 传递性
  - 如果 `x.equals(y)` 返回是 `true`，而且 `y.equals(z)` 返回是 `true`，那么 `z.equals(x)` 也应该返回是 `true`
- 一致性
- 任何情况下 `x.equals(null)` 永远返回是 `false`
- `x.equals(和 x 不同类型的对象)` 永远返回是 `false`
 */
public class EqualsTest {
    public static void main(String[] args) {
        EqualsObj e1 = new EqualsObj("Issac", 19);
        EqualsObj e2 = new EqualsObj("Issac", 19);
        EqualsObj e3 = new EqualsObj("icekylin", 19);

        System.out.println(e1.equals(e2));
        System.out.println(e3.equals(e2));
    }
}

class EqualsObj {
    private String name;
    private int age;

    public EqualsObj() {
    }

    public EqualsObj(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsObj equalsObj = (EqualsObj) o;
        return age == equalsObj.age && Objects.equals(name, equalsObj.name);
    }
}
