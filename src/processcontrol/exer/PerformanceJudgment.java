package processcontrol.exer;
/*
# 说明

- `else` 结构是可选的
- 针对条件表达式
  - 如果多个条件表达式之间是”互斥“关系（没有交集），哪个判断和执行语句声明在上面还是下面无所谓
  - 如果多个条件表达式之间有交集的关系，需要根据实际情况考虑清楚应该将哪个结构声明在上面
  - 如果多个条件表达式之间有包含的关系，通常情况下，需要将范围小的声明在范围大的的上面，否则范围小的就没机会执行了
 */

import java.util.Scanner;

public class PerformanceJudgment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入考试成绩：");
        double performance = scanner.nextDouble();

        if (performance < 60) {
            System.out.println("奖励一个大嘴巴子！");
        } else if (performance <= 80) {
            System.out.println("奖励一个 iPad!");
        } else if (performance <= 99) {
            System.out.println("奖励一个 iPhone!");
        } else if (performance == 100) {
            System.out.println("奖励一辆 BMW!");
        } else {
            System.out.println("输入有误！");
        }
    }
}
