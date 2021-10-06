package typeofdata;

/*
# 浮点型变量

- float
  - 占用存储空间：4 字节
  - 表数范围：-3.403E38 ~ 3.403E38
  - float 表示的数值范围比 long 还大
  - 单精度，尾数可以精确到 7 位有效数字
  - 很多情况下精度难以满足需求
  - 声明 float 型常量，须后加 `f` 或 `F`
- double
  - 占用存储空间：8 字节
  - 表数范围：-1.798E308 ~ 1.798E308
  - 精度是 float 的两倍
  - 通常采用此类型
 */
public class FloatingpointVariable {
    public static void main(String[] args) {
        // double
        double d1 = 123.4;
        System.out.println(d1);

        // float
        float f1 = 12.3F;
        System.out.println(f1);
    }
}
