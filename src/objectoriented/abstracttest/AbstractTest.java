package objectoriented.abstracttest;

/*
# `abstract` 关键字

- `abstract` 可以用来修饰的结构：类、方法
  - `abstract` 修饰类：抽象类
    - 此类不能实例化
    - 抽象类中一定有构造器，便于子类实例化时调用（涉及子类对象实例化的全过程）
    - 开发中都会提供抽象类的子类让子类对象实例化，完成相关操作
  - `abstract` 修饰方法：抽象方法
    - 抽象方法只有方法的声明，没有方法体
    - 包含抽象方法的类一定是一个抽象类，反之抽象类中可以没有抽象方法
    - 若子类重写了父类中的所有的抽象方法后，此子类方可实例化
    - 若子类没有重写父类中所有的抽象方法，则此子类也是一个抽象类，需要使用 `abstract` 修饰

## `abstract` 使用上的注意点

- `abstract` 不能用来修饰属性、构造器等结构
- `abstract` 不能用来修饰私有方法、静态方法、`final` 的方法、`final` 的类
 */
public class AbstractTest {
    public static void main(String[] args) {

    }
}
