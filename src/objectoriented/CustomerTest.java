package objectoriented;

/*
# 类中方法的声明与使用

## 方法

- 描述类应该具有的功能
- 比如
  - `Math` 类
    - `.sqrt()`
    - `.random()`
    - ...
  - `Scanner` 类
    - `.next()`
    - ...
  - `Array` 类
    - `.sort()`
    - `.binarySearch()`
    - `.toString()`
    - `.equals()`
    - ...
- 方法的声明：`权限修饰符 返回值类型 方法名(形参列表) {方法体}`
  - 权限修饰符
    - `private`
    - `public`
    - 缺省
    - `protected`
  - 返回值类型
    - 有返回值
      - 如果方法有返回值，则必须在方法声明时指定返回值的类型
      - 同时方法中需要使用 `return` 关键字返回指定类型的变量或常量
    - 没有返回值
      - 如果方法没有返回值，则声明方法时使用 `void` 来表示
      - 通常没有返回值的方法中就不需要使用 `return`
      - 但是如果使用的话，只能 `return`，表示结束此方法的意思
    - 该不该有返回值
      - 要求
      - 经验：具体问题具体分析
  - 方法名：属于标识符，遵循标识符的规则和规范，需要“见名知意”
  - 形参列表：方法可以声明 0 个、1 个或多个形参
    - 格式：`数据类型1 形参1, 数据类型2  形参2, ...`
    - 该不该有形参
      - 要求
      - 经验：具体问题具体分析
  - 方法体：方法功能的体现

## `return` 关键字的说明

- 使用范围：使用在方法体中
- 作用
  1. 结束方法
  2. 针对于有返回值类型的方法，使用 `return 数据` 方式返回所要的数据
- `return` 后不可以声明执行语句

## 方法的使用

- 方法的使用中可以调用当前类的属性或方法
  - 特殊的：方法A 中又调用了方法A，称方法A 为递归方法
- 方法中不可以定义方法
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.sleep(10);
    }
}

class Customer {
    String name;
    int age;
    boolean isMale;

    public void eat() {
        System.out.println("客户吃饭");
    }

    public void sleep(int hours) {
        System.out.println("客户睡了 " + hours + " 小时");
        eat();
    }

    public String getName() {
        return name;
    }
}
