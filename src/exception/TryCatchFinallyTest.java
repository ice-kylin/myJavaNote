package exception;

import org.junit.Test;

/*
# 异常的处理（抓抛模型）

## 抛

- 程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出
  - 一旦抛出对象以后，之后的代码就不再执行

## 抓

- 可以理解为异常的处理方式
  1. `try - catch - finally`
    - `finally` 是可选的
    - 使用 `try` 将可能出现的异常包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象的类型，去 `catch` 中进行匹配
    - 一旦 `try` 中的异常对象匹配到某一个 `catch` 时，就进入 `catch` 中进行异常的处理。
      - 一旦处理完成，就跳出当前的 `try - catch` 结构（在没有写 `finally` 的情况），继续执行其后的代码
    - `catch` 中的异常类型如果没有子父类关系，则谁声明在上，谁声明在下无所谓
    - `catch` 中的异常类型如果满足子父类关系，则要求子类一定声明在父类的上面，否则报错
    - 常用的异常对象处理的方式
      1. `.getMessage()` 方法
      2. `.printStackTrace()` 方法
    - 在 `try` 结构中声明的变量，在出了 `try` 结构以后就不能再被调用了
    - 使用 `try - catch - finally` 处理编译时异常，使得程序在编译时可能出现的异常延迟到运行时出现
    - `try - catch - finally` 可以嵌套
    - 开发中由于运行时异常比较常见，所以通常就不针对运行时异常编写 `try - catch - finally` 了
      - 针对编译时异常，一定要考虑异常的处理
  2. `throws`

## 开发中如何选择使用 `try - catch - finally` 还是 `throws`

- 如果父类中被重写的方法没有 `throws` 方式处理异常，则子类重写的方法也不能使用 `throws`
  - 意味着如果子类重写的方法中有异常，必须使用 `try - catch - finally` 方式处理
- 执行的方法 a 中，先后又调用了额外的几个方法，这几个方法是递进关系的，建议这几个方法使用 `throws` 的方式进行处理
  - 而执行的方法 a 可以考虑使用 `try - catch - finally` 的方式进行处理
 */
public class TryCatchFinallyTest {
    @Test
    public void test1() {
        String s = "123a";
        int i = 0;

        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("az...");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("233...");
        }

        System.out.println("i = " + i);
    }
}
