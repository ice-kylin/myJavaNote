package objectoriented.exer.wrapper;

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Double> scores = new Vector<>();
        double maxScore = 0.0;
        double currentScore;
        double pointsDifference;

        int i = 0;
        do {
            System.out.print("请输入第 " + (i + 1) + " 个学生成绩：");
            double score = scanner.nextDouble();

            if (score < 0) {
                break;
            } else {
                scores.add(score);
            }

            i++;
        } while (true);

        for (i = 0; i < scores.size(); i++) {
            currentScore = scores.elementAt(i);

            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        System.out.println("编号\t\t成绩\t\t等级");
        for (i = 0; i < scores.size(); i++) {
            currentScore = scores.elementAt(i);
            pointsDifference = maxScore - currentScore;

            if (pointsDifference <= 10) {
                System.out.println(i + 1 + "\t\t" + currentScore + "\t\t" + "A");
            } else if (pointsDifference <= 20) {
                System.out.println(i + 1 + "\t\t" + currentScore + "\t\t" + "B");
            } else if (pointsDifference <= 30) {
                System.out.println(i + 1 + "\t\t" + currentScore + "\t\t" + "C");
            } else {
                System.out.println(i + 1 + "\t\t" + currentScore + "\t\t" + "D");
            }
        }
    }
}
