package multithreading;

public class WinTest1 {
    public static void main(String[] args) {
        WinRunnable winRunnable = new WinRunnable();

        Thread t1 = new Thread(winRunnable);
        Thread t2 = new Thread(winRunnable);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}

class WinRunnable implements Runnable {
    private final Win win = new Win(10);

    @Override
    public void run() {
        while (true) {
            if (win.getTicketNum() > 0) {
                win.sellATicket();
            } else {
                break;
            }
        }
    }
}
