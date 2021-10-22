package processcontrol.exer;

import java.util.Scanner;

public class TheAgeOfTheDog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入 🐕 的年龄：");
        double dogAge = scanner.nextDouble();
        double equivalentAge;

        if (dogAge > 2) {
            equivalentAge = 21 + (dogAge - 2) * 4;
        } else {
            equivalentAge = dogAge * 10.5;
        }

        System.out.println("🐕 的年龄相当于人的年龄 " + equivalentAge + " 岁！");
    }
}
