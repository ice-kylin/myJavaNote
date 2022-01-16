package multithreading;

public class ThreadSafetyTest3 {
    public static void main(String[] args) {
        Win win = new Win(10);

        WinThread2 t1 = new WinThread2(win);
        WinThread2 t2 = new WinThread2(win);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}

class WinThread2 extends Thread {
    private final Win win;

    public WinThread2(Win win) {
        this.win = win;
    }

    private static synchronized boolean sellATicket(Win win) {
        if (win.getTicketNum() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            win.sellATicket();

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void run() {
        while (sellATicket(win)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
