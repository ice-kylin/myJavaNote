package array.exer;

import java.util.Scanner;

public class PerformanceJudgment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double maxScore = 0;
        String grade;

        System.out.print("请输入学生个数：");
        double[] scores = new double[scanner.nextInt()];

        System.out.println();

        System.out.println("请输入 " + scores.length + " 个成绩");

        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个学生的成绩：");
            scores[i] = scanner.nextDouble();
        }

        System.out.println();

        for (double score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        System.out.println("最高分是：" + maxScore);

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= maxScore - 10) {
                grade = "A";
            } else if (scores[i] >= maxScore - 20) {
                grade = "B";
            } else if (scores[i] >= maxScore - 30) {
                grade = "C";
            } else {
                grade = "D";
            }

            System.out.println("学生 " + (i + 1) + " 的分数为：" + scores[i] + ", 评级为：" + grade);
        }
    }
}
