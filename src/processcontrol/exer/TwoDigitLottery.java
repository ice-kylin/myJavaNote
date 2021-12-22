package processcontrol.exer;
/*
## 说明

- 获取一个随机数
  - `Math.random()`
    - 范围：[0.0, 1.0)
    - 公式 ([a, b))：(int) (Math.random() * (b - a + 1) + a)
 */

import java.util.Scanner;

public class TwoDigitLottery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lotteryNumber = (int) (Math.random() * 90 + 10);

        System.out.println("请输入两位数的彩票号码：");
        int enteredNumber = scanner.nextInt();

        if (lotteryNumber == enteredNumber) {
            System.out.println("彩票号码：" + lotteryNumber + "，两位数一致！赢得奖金 10000 美元！");
        } else if ((lotteryNumber % 10) == (enteredNumber % 10) || (lotteryNumber - lotteryNumber % 10) / 10 == (enteredNumber - enteredNumber % 10) / 10) {
            System.out.println("彩票号码：" + lotteryNumber + "，一位数相同且顺序一致！赢得奖金 3000 美元！");
        } else if ((lotteryNumber % 10) == (enteredNumber - enteredNumber % 10) / 10 || (lotteryNumber - lotteryNumber % 10) / 10 == (enteredNumber % 10)) {
            System.out.println("彩票号码：" + lotteryNumber + "，一位数相同但顺序不一致！赢得奖金 1000 美元！");
        } else {
            System.out.println("彩票号码：" + lotteryNumber + "，很遗憾没有中奖！");
        }
    }
}
