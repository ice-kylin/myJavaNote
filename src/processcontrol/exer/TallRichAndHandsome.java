package processcontrol.exer;

import java.util.Scanner;

public class TallRichAndHandsome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入身高（cm）：");
        int height = scanner.nextInt();
        System.out.println("请输入财富（w）：");
        int worth = scanner.nextInt();
        System.out.println("请输入颜值（true / false）：");
        boolean face = scanner.nextBoolean();

        if (height >= 180 && worth >= 1000 && face) {
            System.out.println("我一定要嫁给他！！！");
        } else if (height >= 180 || worth >= 1000 || face) {
            System.out.println("嫁吧！比上不足，比下有余！");
        } else {
            System.out.println("不嫁！");
        }
    }
}
