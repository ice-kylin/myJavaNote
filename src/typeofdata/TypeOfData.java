package typeofdata;

/*
# 数据类型

## 按照数据类型

- 基本数据类型（primitive type）
  - 数值型
    - 整数类型
      - byte
      - short
      - int
      - long
    - 浮点类型
      - float
      - double
  - 字符型
    - char
  - 布尔型
    - boolean
- 引用数据类型（reference type）
  - 类（class）
  - 接口（interface）
  - 数组（array）

# 按照变量在类中声明的位置

- 成员变量
- 局部变量
 */
public class TypeOfData {
    public static void main(String[] args) {
        TypeOfData tod = new TypeOfData();

        System.out.println("" + tod.addOneToFloat(1.0f));
    }

    float addOneToFloat(float number) {
        return ++number;
    }
}
