package objectoriented;

/*
# 类中属性的使用

## 属性（成员变量） vs. 局部变量

1. 相同点
  - 定义变量的格式：`数据类型 变量名 = 变量值;`
  - 先声明，后使用
  - 变量都有其对应的作用域
2. 不同点
  - 在类中声明的位置的不同
    - 属性：直接定义在类的一对 `{}` 内
    - 局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
  - 权限修饰符的不同
    - 属性：可以在声明属性时指明其权限，使用权限修饰符
      - 常用的权限修饰符
        - `private`
        - `public`
        - 缺省
        - `protected`
    - 局部变量：不可以使用权限修饰符
  - 默认初始化值的情况
    - 属性：类的属性根据其类型，都有默认初始化值
      - 整型（byte、short、int、long）：`0`
      - 浮点型（float）：`0.0`
      - 字符型（char）：`0`
      - 布尔型（boolean）：`false`
      - 引用数据类型（类、数组、接口）：`null`
    - 局部变量：没有默认初始化值
      - 意味着在调用局部变量之前必须显式地赋值
      - 特别地，形参在调用时赋值即可
  - 在内存中加载的位置：
    - 属性：加载到堆空间中（非 static）
    - 局部变量：加载到栈空间中
 */
public class UserTest {
    public static void main(String[] args) {
        User u1 = new User();
        System.out.println("u1.name = " + u1.name);
        System.out.println("u1.age = " + u1.age);
        System.out.println("u1.isMale = " + u1.isMale);
    }
}

class User {
    // 属性（成员变量）
    String name;
    int age;
    boolean isMale;

    public void talk(String language) { // language：形参（局部变量）
        System.out.println("使用 " + language + " 交流");
    }

    public void eat() {
        String food = "🍚"; // 声明在方法内的变量（局部变量）
        System.out.println("吃 " + food);
    }
}
