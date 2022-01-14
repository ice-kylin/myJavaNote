package multithreading.exer;

public class ThreadDemo {
    public static void main(String[] args) {
        IterateOverEvenNumsThread t1 = new IterateOverEvenNumsThread();
        IterateOverOddNumsThread t2 = new IterateOverOddNumsThread();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }.start(); // 创建 Thread 类的匿名子类的方式

        t1.start();
        t2.start();
    }
}

class IterateOverEvenNumsThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class IterateOverOddNumsThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
