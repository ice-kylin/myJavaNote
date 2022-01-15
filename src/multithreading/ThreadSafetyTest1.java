package multithreading;

public class ThreadSafetyTest1 {
    public static void main(String[] args) {
        Win win = new Win(10);

        WinThread1 t1 = new WinThread1(win);
        WinThread1 t2 = new WinThread1(win);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}

class WinThread1 extends Thread {
    private final Win win;

    public WinThread1(Win win) {
        this.win = win;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (WinThread.class) {
                // synchronized (win) {
                if (win.getTicketNum() > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    win.sellATicket();
                } else {
                    break;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
