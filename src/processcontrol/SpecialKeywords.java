package processcontrol;

/*
# 特殊关键字的使用

## `break`

- 使用范围
  - `switch - case`
  - 循环结构
- 作用
  - 结束当前循环

## `continue`

- 使用范围
  - 循环结构
- 作用
  - 结束当次循环

## 共同点

- 关键字后面不能声明执行语句
- 跳出此关键字最近的一层循环
- 可以通过 label 结束指定标识的一层循环
 */
public class SpecialKeywords {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 4 == 0) {
                /*
                continue;
                */
                break;
            }
            System.out.println(i);
        }

        System.out.println();

        label:
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

                if (i == 2) {
                    /*
                    break label;
                    */
                    continue label;
                }
            }
            System.out.println();
        }
    }
}
