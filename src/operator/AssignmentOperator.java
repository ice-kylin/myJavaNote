package operator;

/*
# 赋值运算符

- `=`
- `+=`
- `-=`
- `*=`
- `/=`
- `%=`
 */
public class AssignmentOperator {
    public static void main(String[] args) {
        // `=`
        int i1, i2;
        i1 = i2 = 10; // 连续赋值
        System.out.println("i1 = " + i1 + ", i2 = " + i2);

        int i3 = 20, i4 = 30;
        System.out.println("i3 = " + i3 + ", i4 = " + i4);

        // +=
        int i5 = 10;
        i5 += 2; // 不会改变数据类型
        System.out.println("i5 = " + i5);
    }
}
