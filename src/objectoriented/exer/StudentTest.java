package objectoriented.exer;

public class StudentTest {
    public static void main(String[] args) {
        Student[] stds = new Student[20];
        Student tmp;

        for (int i = 0; i < stds.length; i++) {
            stds[i] = new Student();
            stds[i].number = i + 1;
            stds[i].state = (int) (Math.random() * 6) + 1;
            stds[i].score = (int) (Math.random() * 101);
        }

        for (Student std : stds) {
            System.out.println(std.getInfo());
        }

        System.out.println();

        for (Student std : stds) {
            if (std.state == 3) {
                System.out.println(std.getInfo());
            }
        }

        System.out.println();

        for (int i = 0; i < stds.length; i++) {
            for (int j = stds.length - 1; j > i; j--) {
                if (stds[j].score < stds[j - 1].score) {
                    tmp = stds[j];
                    stds[j] = stds[j - 1];
                    stds[j - 1] = tmp;
                }
            }
        }

        for (Student std : stds) {
            System.out.println(std.getInfo());
        }
    }
}

class Student {
    int number;
    int state;
    int score;

    public String getInfo() {
        return "学号：" + number + "，年级：" + state + "，成绩：" + score;
    }
}
