package objectoriented;

/*
# `.toString()`

- 当输出一个对象的引用时，实际上就是调用当前对象的 `.toString()`
- `Object` 类中 `.toString()` 的定义：
  ```
  public String toString() {
      return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
  }
  ```
- 像 `String`、`Date`、`File`、包装类等都重写了 `Object` 类中的 `.toString()` 方法
  - 使得调用对象的 `.toString()` 时返回“实体内容”信息
- 自定义类也可以重写 `.toString()` 方法，当调用此方法时，返回对象的实体内容
 */
public class ToStringTest {
    public static void main(String[] args) {
        String str = "icekylin";
        System.out.println(str);
    }
}
