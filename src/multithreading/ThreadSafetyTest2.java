package multithreading;

public class ThreadSafetyTest2 {
    public static void main(String[] args) {
        WinRunnable2 w = new WinRunnable2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}

class WinRunnable2 implements Runnable {
    private final Win win = new Win(10);

    private synchronized boolean sellATicket() {
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
        while (sellATicket()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
