package annotation;

import org.junit.Test;

import java.util.ArrayList;

/*
# 注解（Annotation）

## 理解

- JDK 5.0 新增的功能
- 注解其实就是代码里的特殊标记
  - 这些标记可以在编译，类加载，运行时被读取，并执行相应的逻辑
  - 通过使用注解，可以在不改变原有逻辑的情况下在源文件中嵌入一些补充信息
- 在 JavaSE 中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等
  - 在 JavaSE / Android 开发中注解占据了更重要的角色
    - 例如用来配置应用程序的任何切面，代替 JavaEE 旧版中遗留的繁琐的繁冗代码和 XML 配置等

## 使用实例

1. 生成文档相关的注释
  - `@author`：标明开发该类模块的作者，多个作者之间使用 `,` 分割
  - `@version`：标明该类模块的版本
  - `@see`：参考转向，也就是相关主题
  - `@since`：从哪个版本开始增加的
  - `@param`
    - 对方法中某参数的说明，如果没有参数就不能写
    - 格式：`@param 形参名 形参类型 形参说明`
    - 可以并列多个
  - `@return`
    - 对方法返回值的说明，如果方法的返回值类型是 `void` 就不能写
    - `@return 返回值类型 返回值说明`
  - `@exception`
    - 对方法可能抛出的异常进行说明，如果方法没有用 `throws` 显式地抛出异常就不能写
    - `@exception 异常类型 异常说明`
    - 可以并列多个
2. 在编译时进行格式检查（JDK 内置的三个基本注解）
  - `@Override`：限定重写父类方法
  - `@Deprecated`：用于表示所修饰的元素（类、方法等）已过时（通常是因为所修饰的结构危险或存在更好的选择）
  - `@SuppressWarnings`：抑制编译器警告
3. 跟踪代码依赖性，实现代替配置文件功能

## 自定义注解（参照 `@SuppressWarnings` 定义）

1. 注解声明为 `@interface`
2. 内部定义成员，通常使用 `value` 表示
3. 可以指定成员的默认值，使用 `default` 定义
4. 如果自定义注解没有成员，表面是一个表示作用

### 说明

- 如果注解有成员，在使用注解时，需要指明成员的值
- 自定义注解必须配上注解的信息处理流程（使用反射）才有意义
- 自定义注解通常都会指明两个元注解：`@Retention` 和 `@Target`

## JDK 中的元注解

- JDK 的元注解用于修饰其它注解定义
- JDK 5.0 提供了 4 个标准的元注解类型
  - `@Retention`
    - 指定所修饰的注解的声明周期
      - `SOURCE`
      - `CLASS`（默认行为）
      - `RUNTIME`（只有声明为 `RUNTIME` 生命周期的注解，才能够通过反射获取）
  - `@Target`
    - 用于指定被修饰的注解能够用于修饰哪些程序元素
      - `TYPE`
      - `FIELD`
      - `METHOD`
      - `PARAMETER`
      - `CONSTRUCTOR`
      - `LOCAL_VARIABLE`
      - `ANNOTATION_TYPE`
      - `PACKAGE`
      - `TYPE_PARAMETER`
      - `TYPE_USE`
      - `MODULE`
  - `@Documented`：表示所修饰的注解在被 `javadoc` 解析时保留下来
  - `@Inherited`：被它修饰的注解将具有继承性

## JDK 8.0 中注解的新特性：可重复注解、类型注解

- 可重复注解
  1. 在 `Xxx` 上声明 `@Repeatable`，成员值为 `Xxxs.class`
  2. `Xxxs` 的 `@Target` 和 `@Retention` 等元注解和 `Xxx` 的相同
- 类型注解
  - `ElementType.TYPE_PARAMETER`：表示该注解能写在类型变量的声明语句中（如：泛型声明）
  - `ElementType.TYPE_USE`：表示该注解能写在使用类型的任何语句中
 */
public class AnnotationTest {
    @Test
    public void test1() {
        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();
    }

    @Test
    @MyAnnotation(value = "hi")
    @MyAnnotation(value = "what's up")
    public void test2() {
        System.out.println("Hello");
    }

    @Test
    public void test3() throws @MyAnnotation RuntimeException {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        @MyAnnotation int num = (@MyAnnotation int) 10L;
    }
}
