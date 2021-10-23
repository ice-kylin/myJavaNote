package processcontrol.exer;
/*
## 说明

- 如果 `switch - case` 中的多个 case 的执行语句相同，则可以考虑合并
 */

import java.util.Scanner;

public class JudgePass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");
        double score = scanner.nextDouble();

        switch ((int) score / 60) {
            case 1:
                System.out.println(score + " 分，合格了");
                break;
            case 0:
                System.out.println(score + " 分，不合格！");
        }
    }
}
