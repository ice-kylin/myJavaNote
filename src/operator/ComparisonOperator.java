package operator;

/*
# 比较运算符

- 比较运算符的结果是 boolean 类型
- 区分 `==` 和 `=`

- `==`
  - 相等于
- `!=`
  - 不等于
- `<`
  - 小于
- `>`
  - 大于
- `<=`
  - 小于等于
- `>=`
  - 大于等于
- `instanceof`
  - 检查是否是类的对象
 */
public class ComparisonOperator {
    public static void main(String[] args) {
        int i = 10, j = 20;

        System.out.println("i == j = " + (i == j));
        System.out.println("i = j = " + (i = j));
    }
}
