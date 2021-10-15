package processcontrol;

/*
# `if - else` 结构（条件判断结构）

- `if(条件表达式) {执行表达式}`
- `if(条件表达式) {执行表达式1} else {执行表达式2}`（二选一）
- `if(条件表达式1) {执行表达式1} else if(条件表达式2) {执行表达式2} else if(条件表达式3) {执行表达式3} ...`（多选一）
 */
public class IfElse {
    public static void main(String[] args) {
        int heartBeat = 101;

        if (heartBeat < 60 || heartBeat > 100) {
            System.out.println("需要进一步检查...");
        }

        System.out.println("检查结束...");

        // 二选一
        int age = 19;

        if (age < 18) {
            System.out.println("你不能喝酒");
        } else {
            System.out.println("可以喝酒了");
        }

        // 多选一
        age = 0;

        if (age <= 0) {
            System.out.println("输入的年龄非法");
        } else if (age < 18) {
            System.out.println("你不能喝酒");
        } else {
            System.out.println("可以喝酒了");
        }
    }
}
